package com.example.mospolytech.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mospolytech.R
import com.example.mospolytech.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("binding = null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewFavourite.setOnClickListener {
            launchFavouriteFragment()
        }
        binding.buttonFind.setOnClickListener {
            val first = binding.spinnerdir.selectedItem.toString()
            val second = binding.spinnerdir2.selectedItem.toString()
            val third = binding.spinnerdir3.selectedItem.toString()
            val level = binding.spinnerEdLevel.selectedItem.toString()
            val list = mutableListOf<String>().apply {
                add(first)
                add(second)
                add(third)
                add(level)
            }
            if (list.contains("Русский") && list.contains("Математика(Профиль)") && (list.contains("Информатика") || list.contains(
                    "Физика"
                )) && list.contains("Бакалавриат")
            ) {
                launchInfRusMathFragment()
            }
        }
    }

    private fun launchFavouriteFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, FavouriteFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun launchInfRusMathFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, InfMathRusFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}