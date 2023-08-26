package com.example.carfinder.utils

abstract class ViewState {
    object Initial : ViewState()
    object Loading : ViewState()
    data class Error(val error: String?) : ViewState()
}