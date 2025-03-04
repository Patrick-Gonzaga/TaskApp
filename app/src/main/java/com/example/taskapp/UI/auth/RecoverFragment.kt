package com.example.taskapp.UI.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentLoginBinding
import com.example.taskapp.databinding.FragmentRecoverBinding
import com.example.taskapp.util.initToolbar
import com.example.taskapp.util.showBottomSheet


class RecoverFragment : Fragment() {

    private var _binding: FragmentRecoverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners(){
        binding.btnSend.setOnClickListener {
            auth()
        }
    }

    private fun auth(){
        val email = binding.inputEmail.text.toString().trim()

        if(email.isNotBlank()){
            Toast.makeText(requireContext(), "Deu bão", Toast.LENGTH_SHORT).show()

        }else{
            showBottomSheet(message = getString(R.string.emailEmpty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}