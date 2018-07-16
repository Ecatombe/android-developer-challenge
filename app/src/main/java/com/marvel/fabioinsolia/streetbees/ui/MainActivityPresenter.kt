package com.marvel.fabioinsolia.streetbees.ui

import com.marvel.fabioinsolia.streetbees.BuildConfig
import com.marvel.fabioinsolia.streetbees.NamedScheduler
import com.marvel.fabioinsolia.streetbees.NamedScheduler.SchedulerType.IO
import com.marvel.fabioinsolia.streetbees.NamedScheduler.SchedulerType.UI
import com.marvel.fabioinsolia.streetbees.base.BasePresenter
import com.marvel.fabioinsolia.streetbees.data.model.Result
import com.marvel.fabioinsolia.streetbees.data.remote.IAPIClient
import com.marvel.fabioinsolia.streetbees.ui.MainActivityPresenter.View
import com.marvel.fabioinsolia.streetbees.utils.IMD5Converter
import io.reactivex.Scheduler
import timber.log.Timber
import java.sql.Timestamp
import javax.inject.Inject


class MainActivityPresenter @Inject constructor(
    @NamedScheduler(IO) private val ioScheduler: Scheduler,
    @NamedScheduler(UI) private val uiScheduler: Scheduler,
    private val converter: IMD5Converter,
    var client: IAPIClient
) : BasePresenter<View>() {

  override fun onViewAttached(view: View) {
    super.onViewAttached(view)

    val timestamp = Timestamp(System.currentTimeMillis()).time.toString()

    disposeOnViewDetach(client.retrieveComics(timestamp, BuildConfig.MarvelPublicKey,
        converter.convert(timestamp)
    ).subscribeOn(ioScheduler)
        .observeOn(uiScheduler)
        .subscribe({ result ->
          Timber.d("Successfully call the BE")
          view.inflateRecycleView(result.data?.results!!)
        }, { error ->
          Timber.e("Error while call the BE")
          view.showError(error.message)
        }))

  }

  interface View {
    fun inflateRecycleView(results: List<Result>)
    fun showError(error: String?)
  }
}