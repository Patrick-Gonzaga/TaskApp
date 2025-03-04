package com.example.taskapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentFormTaskBinding
import com.example.taskapp.databinding.FragmentRegisterBinding
import com.example.taskapp.util.initToolbar
import com.example.taskapp.util.showBottomSheet


class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSend.setOnClickListener {
            auth()
        }

    }

    private fun auth() {
        val desc = binding.inputDesc.text.toString().trim()
        var radioGroupStatusVerify = binding.rgStatus.checkedRadioButtonId
        if (desc.isNotBlank()) {
            if (radioGroupStatusVerify == -1) {
                showBottomSheet(message = getString(R.string.taskStatusEmpty))
            } else {
                Toast.makeText(requireContext(), "Deu bão", Toast.LENGTH_SHORT).show()

            }
        } else {
            showBottomSheet(message = getString(R.string.taskDescriptionEmpty))

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}