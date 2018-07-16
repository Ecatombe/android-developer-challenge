package com.marvel.fabioinsolia.streetbees.di

import com.marvel.fabioinsolia.streetbees.utils.IMD5Converter
import com.marvel.fabioinsolia.streetbees.utils.MD5Converter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UtilsModule {

  @Provides
  @Singleton
  internal fun provideMD5Converter(): IMD5Converter {
    return MD5Converter()
  }
}