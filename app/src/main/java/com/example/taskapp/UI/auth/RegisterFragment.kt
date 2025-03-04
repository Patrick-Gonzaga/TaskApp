package com.example.taskapp.UI.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentRegisterBinding
import com.example.taskapp.util.initToolbar
import com.example.taskapp.util.showBottomSheet

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
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
        val password = binding.inputPassword.text.toString().trim()

        if(email.isNotBlank()){
            if(password.isNotBlank()){
                Toast.makeText(requireContext(), "Deu Bom", Toast.LENGTH_SHORT).show()
            }else{
                showBottomSheet(message = getString(R.string.passwordRegisterEmpty))
            }
        }else{
            showBottomSheet(message = getString(R.string.emailRegisterEmpty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}