package com.junction.seoul.hunterandroid.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.databinding.FragmentBottomDialogListDialogBinding
import kotlinx.android.synthetic.main.fragment_bottom_dialog_list_dialog.*

class BottomDialogFragment(val onDelete: () -> Unit) : BottomSheetDialogFragment() {

  lateinit var binding: FragmentBottomDialogListDialogBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate<FragmentBottomDialogListDialogBinding>(
      inflater,
      R.layout.fragment_bottom_dialog_list_dialog,
      container,
      false
    ).apply {
      lifecycleOwner = viewLifecycleOwner
    }
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    btCancle.setOnClickListener {
      dialog?.dismiss()
    }
    btnRemove.setOnClickListener {
      onDelete.invoke()
      dialog?.dismiss()
    }
  }
}