package com.junction.seoul.hunterandroid.setting

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.databinding.ActivityAddAndRemoveTextBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

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
      viewModel.busNumbers.collect {
        adapter.setItem(it)
      }
    }
    uiStateJob = lifecycleScope.launch {
      viewModel.pickBus.collect { pickBus ->
        if (pickBus.title == null) return@collect
        BottomDialogFragment.newInstance(
          busNumber = pickBus.title,
          onDelete = { viewModel.deleteBusNumber() }
        ).run {
          show(supportFragmentManager, tag)
        }
      }
    }
  }

  override fun onStop() {
    uiStateJob?.cancel()
    super.onStop()
  }

  companion object {
    fun launch(context: Context) {
      context.startActivity(Intent(context, AddAndDeleteTextActivity::class.java))
    }
  }

}