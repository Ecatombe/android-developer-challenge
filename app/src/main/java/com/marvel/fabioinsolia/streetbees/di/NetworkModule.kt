package com.marvel.fabioinsolia.streetbees.di


import com.marvel.fabioinsolia.streetbees.NamedScheduler
import com.marvel.fabioinsolia.streetbees.NamedScheduler.SchedulerType.IO
import com.marvel.fabioinsolia.streetbees.NamedScheduler.SchedulerType.UI
import com.marvel.fabioinsolia.streetbees.data.remote.APIProvider
import com.marvel.fabioinsolia.streetbees.data.remote.IAPIClient
import com.marvel.fabioinsolia.streetbees.data.remote.IAPIProvider
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton


@Module
class NetworkModule {

  @Provides
  @Singleton
  internal fun provideAPIProvider(): IAPIClient {
    return APIProvider().create()
  }

  @Provides
  @NamedScheduler(IO)
  internal fun provideIoScheduler(): Scheduler {
    return Schedulers.io()
  }

  @Provides
  @NamedScheduler(UI)
  internal fun provideUiScheduler(): Scheduler {
    return AndroidSchedulers.mainThread()
  }
}