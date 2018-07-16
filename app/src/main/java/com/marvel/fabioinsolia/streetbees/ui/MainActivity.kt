package com.marvel.fabioinsolia.streetbees.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.marvel.fabioinsolia.streetbees.R.layout
import com.marvel.fabioinsolia.streetbees.StreetbeesApp
import com.marvel.fabioinsolia.streetbees.adapters.ComicAdapter
import com.marvel.fabioinsolia.streetbees.data.model.Result
import kotlinx.android.synthetic.main.activity_main.list
import timber.log.Timber
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

  @Inject
  lateinit var presenter: MainActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    StreetbeesApp.injector.inject(this)
    presenter.onViewAttached(this)

  }


  override fun inflateRecycleView(results: List<Result>) {
    var gridLayoutManager = GridLayoutManager(this, 2)
    list.layoutManager = gridLayoutManager
    list.adapter = ComicAdapter(results)
  }

  override fun showError(error: String?) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    Timber.d(error)
  }

}
