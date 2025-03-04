package com.example.taskapp.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import com.example.taskapp.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.example.taskapp.R

fun Fragment.initToolbar(toolbar: Toolbar) {
    // Define a Toolbar como a ActionBar da Activity
    (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

    // Remove o título padrão da Toolbar
    (activity as? AppCompatActivity)?.title = ""

    // Habilita o botão de navegação "voltar"
    (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)

    // Define a ação do botão de navegação
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()  // Forma moderna de lidar com "voltar"
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String,
    onClick: () -> Unit = {}
) {

    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding: BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.txtWarning.text = getText(titleDialog ?: R.string.textWarningBS)
    binding.msgWarning.text = message
    binding.btnWarning.text = getText(titleButton ?: R.string.btnWarningBS)
    binding.btnWarning.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }
    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}