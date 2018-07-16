package com.marvel.fabioinsolia.streetbees

import android.app.Application
import com.marvel.fabioinsolia.streetbees.di.AppComponent
import com.marvel.fabioinsolia.streetbees.di.DaggerAppComponent
import com.marvel.fabioinsolia.streetbees.di.NetworkModule
import com.marvel.fabioinsolia.streetbees.di.UtilsModule
import timber.log.Timber

class StreetbeesApp : Application() {

  companion object {
    @JvmStatic
    lateinit var injector: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    injector = createInjectionComponent()
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }

  }

  private fun createInjectionComponent(): AppComponent {
    return DaggerAppComponent
        .builder()
        .networkModule(NetworkModule())
        .utilsModule(UtilsModule())
        .build()
  }


}