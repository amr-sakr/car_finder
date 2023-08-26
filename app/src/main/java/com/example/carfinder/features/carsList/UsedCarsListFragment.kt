package com.example.carfinder.features.carsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.carfinder.databinding.UsedCarsListFragmentBinding
import com.example.carfinder.utils.ViewState
import com.example.carfinder.utils.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsedCarsListFragment : Fragment() {

    private val adapter: CarsListAdapter by lazy {
        CarsListAdapter()
    }

    private var _binding: UsedCarsListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UsedCarsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UsedCarsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCars.adapter = adapter
        collectUiState()
    }

    private fun collectUiState() {
        collectAsStateWithLifecycle(viewModel.carsListState) { state ->
            if (state !is ViewState.Loading) {
                binding.progressBar.visibility = View.GONE
            }

            when (state) {
                is ViewState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is CarsListState.CarsListLoaded -> {
                    adapter.submitList(state.cars)
                }
            }
        }

        collectAsStateWithLifecycle(viewModel.carsListError) { state ->
            when (state) {
                is ViewState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "${state.error}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvCars.adapter = null
        _binding = null
    }
}