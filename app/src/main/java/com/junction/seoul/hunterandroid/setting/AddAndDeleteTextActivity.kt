package com.junction.seoul.hunterandroid.setting

import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.data.makeBusNumbers
import com.junction.seoul.hunterandroid.databinding.ActivityAddAndRemoveTextBinding

class AddAndDeleteTextActivity :
  BaseActivity<ActivityAddAndRemoveTextBinding>(layoutRes = R.layout.activity_add_and_remove_text) {

  private lateinit var adapter: AddAndDeleteAdapter

  override fun onStart() {
    super.onStart()
    setupAdapter()
  }

  private fun setupAdapter() {
    adapter = AddAndDeleteAdapter()
    binding.rv.adapter = adapter
    adapter.setItem(makeBusNumbers())
  }

}