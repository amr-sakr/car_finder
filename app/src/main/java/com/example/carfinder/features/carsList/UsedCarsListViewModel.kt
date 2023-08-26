package com.example.carfinder.features.carsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carfinder.data.models.UsedCarsResponse
import com.example.carfinder.data.repositories.ICarsListRepository
import com.example.carfinder.di.MainDispatcher
import com.example.carfinder.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsedCarsListViewModel @Inject constructor(
    private val repository: ICarsListRepository,
    @MainDispatcher
    private val mainDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _carsListState = MutableStateFlow<ViewState>(ViewState.Initial)
    val carsListState = _carsListState.asStateFlow()

    private val _carsListError = Channel<ViewState>()
    val carsListError = _carsListError.receiveAsFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            _carsListError.send(ViewState.Error(throwable.message?: "Something went wrong"))
        }
    }
    init {
        getCarsList()
    }

    private fun getCarsList() {
        viewModelScope.launch(handler + mainDispatcher) {
            _carsListState.emit(ViewState.Loading)
            repository.getCarsList().collect { carsList ->
                _carsListState.emit(CarsListState.CarsListLoaded(carsList))
            }
        }
    }
}

sealed class CarsListState : ViewState() {
    data class CarsListLoaded(val cars: UsedCarsResponse) : CarsListState()
}