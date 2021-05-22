package com.junction.seoul.hunterandroid

import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.databinding.ActivityMainBinding
import com.junction.seoul.hunterandroid.setting.AddAndDeleteTextActivity
import com.junction.seoul.hunterandroid.setting.SettingActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

  override fun onStart() {
    super.onStart()

    binding.favorite.setOnClickListener {
      AddAndDeleteTextActivity.launch(this)
    }

    binding.setting.setOnClickListener {
      SettingActivity.launch(this)
    }
  }
}

