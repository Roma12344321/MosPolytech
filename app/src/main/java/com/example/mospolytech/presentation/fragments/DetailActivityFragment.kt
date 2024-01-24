package com.example.mospolytech.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mospolytech.databinding.FragmentDetailActivityBinding
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.presentation.viewmodel.DirectionApp
import com.example.mospolytech.presentation.viewmodel.MainViewModel
import com.example.mospolytech.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class DetailActivityFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as DirectionApp).component
    }

    private lateinit var direction: Direction

    private var _binding: FragmentDetailActivityBinding? = null

    private val binding: FragmentDetailActivityBinding
        get() = _binding ?: throw RuntimeException("Do not use binding there")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDirection(direction)
        viewModel.direction.observe(viewLifecycleOwner) {
            with(binding) {
                textViewDetailInformation.text = it.name
                textViewTextObjects.text = it.text
                textViewWork.text = it.work
                textViewAdvantages.text = it.advantages
            }
        }
        setStar()
    }

    private fun setStar() {
        val starOff = ContextCompat.getDrawable(requireContext(), android.R.drawable.star_big_off)
        val starOn = ContextCompat.getDrawable(requireContext(), android.R.drawable.star_big_on)
        viewModel.getFavouriteDirection(direction.id)
            .observe(viewLifecycleOwner) { itDir: Direction ->
                if (!itDir.favourite) {
                    binding.imageView.setImageDrawable(starOff)
                    binding.imageView.setOnClickListener {
                        viewModel.changeFavouriteState(itDir)
                    }
                } else {
                    binding.imageView.setImageDrawable(starOn)
                    binding.imageView.setOnClickListener {
                        viewModel.changeFavouriteState(itDir)
                    }
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getParcelable<Direction>(KEY_DIRECTION)?.let {
            direction = it
        }
    }

    companion object {

        private const val KEY_DIRECTION = "direction"

        fun newInstance(direction: Direction): DetailActivityFragment {
            return DetailActivityFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_DIRECTION, direction)
                }
            }
        }
    }
}