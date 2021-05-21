package com.junction.seoul.hunterandroid.app

import android.app.Application
import timber.log.Timber

class HunterAndroidApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    Timber.plant(Timber.DebugTree())
  }
}