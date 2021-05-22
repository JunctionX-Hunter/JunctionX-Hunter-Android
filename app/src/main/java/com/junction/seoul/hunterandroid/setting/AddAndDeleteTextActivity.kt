package com.junction.seoul.hunterandroid.setting

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.databinding.ActivityAddAndRemoveTextBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddAndDeleteTextActivity :
  BaseActivity<ActivityAddAndRemoveTextBinding>(layoutRes = R.layout.activity_add_and_remove_text) {

  private lateinit var adapter: AddAndDeleteAdapter
  private val viewModel by viewModels<AddAndDeleteViewModel>()
  private var uiStateJob: Job? = null

  override fun onStart() {
    super.onStart()
    setupAdapter()
    setupViewModel()
  }

  private fun setupAdapter() {
    adapter = AddAndDeleteAdapter(viewModel)
    binding.rv.adapter = adapter
  }

  private fun setupViewModel() {
    viewModel.updateBusNumbers()
    uiStateJob = lifecycleScope.launch {

      viewModel.busNumber.collect {
        adapter.setItem(it)
      }
    }
  }

  override fun onStop() {
    uiStateJob?.cancel()
    super.onStop()

  }

}