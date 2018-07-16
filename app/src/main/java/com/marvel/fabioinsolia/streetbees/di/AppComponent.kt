package com.marvel.fabioinsolia.streetbees.di

import com.marvel.fabioinsolia.streetbees.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class, UtilsModule::class))
interface AppComponent {
  fun inject(activity: MainActivity)
}