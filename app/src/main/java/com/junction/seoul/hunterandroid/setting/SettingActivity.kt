package com.junction.seoul.hunterandroid.setting

import android.content.Context
import android.content.Intent
import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.databinding.ActivitySettingBinding

class SettingActivity : BaseActivity<ActivitySettingBinding>(layoutRes = R.layout.activity_setting) {

  companion object {
    fun launch(context: Context) {
      context.startActivity(Intent(context, SettingActivity::class.java))
    }
  }
}