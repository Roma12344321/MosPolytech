package com.example.mospolytech.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mospolytech.databinding.FragmentDetailActivityBinding
import com.example.mospolytech.domain.Direction

class DetailActivityFragment : Fragment() {

    private lateinit var direction: Direction

    private var _binding : FragmentDetailActivityBinding? = null

    private val binding : FragmentDetailActivityBinding
        get() = _binding ?: throw RuntimeException("Do not use binding there")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailActivityBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            textViewDetailInformation.text = direction.name
            textViewTextObjects.text = direction.text
            textViewWork.text = direction.work
            textViewAdvantages.text = direction.advantages
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs(){
        requireArguments().getParcelable<Direction>(KEY_DIRECTION)?.let {
            direction = it
        }
    }

    companion object{

        private const val KEY_DIRECTION = "direction"

        fun newInstance(direction: Direction) : DetailActivityFragment {
            return DetailActivityFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_DIRECTION,direction)
                }
            }
        }
    }
}