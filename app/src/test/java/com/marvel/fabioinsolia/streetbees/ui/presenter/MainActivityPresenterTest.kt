package com.marvel.fabioinsolia.streetbees.ui.presenter

import com.marvel.fabioinsolia.streetbees.BuildConfig
import com.marvel.fabioinsolia.streetbees.base.BasePresenterTest
import com.marvel.fabioinsolia.streetbees.data.model.ComicList
import com.marvel.fabioinsolia.streetbees.data.model.Data
import com.marvel.fabioinsolia.streetbees.data.model.Result
import com.marvel.fabioinsolia.streetbees.data.remote.IAPIClient
import com.marvel.fabioinsolia.streetbees.ui.MainActivityPresenter
import com.marvel.fabioinsolia.streetbees.ui.MainActivityPresenter.View
import com.marvel.fabioinsolia.streetbees.utils.IMD5Converter
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.mockito.Mock


class MainActivityPresenterTest : BasePresenterTest<MainActivityPresenter, MainActivityPresenter.View>() {
  @Mock
  lateinit var client: IAPIClient

  @Mock
  lateinit var converter: IMD5Converter

  override fun createPresenter(): MainActivityPresenter = MainActivityPresenter(
      Schedulers.trampoline(), Schedulers.trampoline(), converter, client)

  override fun createView(): View {
    return mock()
  }

  @Test
  fun onViewAttachedReturnComicList() {
    val comicList = mock<ComicList>()
    val data = mock<Data>()
    val result = mock<List<Result>>()
    whenever(converter.convert(any())).thenReturn("a08a7e0734fe648117278932375f24d2")
    whenever(client.retrieveComics(any(), any(), any())).thenReturn(Single.just(comicList))
    whenever(comicList.data).thenReturn(data)
    whenever(comicList.data?.results).thenReturn(result)
    presenter.onViewAttached(view)
    verify(view).inflateRecycleView(result)
  }

  @Test
  fun onViewAttachedReturnError() {
    val error = Throwable("error")
    whenever(converter.convert(any())).thenReturn("a08a7e0734fe648117278932375f24d2")
    whenever(client.retrieveComics(any(), any(), any())).thenReturn(Single.error(error))
    presenter.onViewAttached(view)
    verify(view).showError(error.message)
  }

}