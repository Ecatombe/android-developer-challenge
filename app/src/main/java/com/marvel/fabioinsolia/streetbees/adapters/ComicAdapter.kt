package com.marvel.fabioinsolia.streetbees.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.marvel.fabioinsolia.streetbees.R
import com.marvel.fabioinsolia.streetbees.data.model.Result

class ComicAdapter(
    private val comicList: List<Result>
) : RecyclerView.Adapter<ComicViewHolder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    return createChecklistViewHolder(layoutInflater, parent)
  }

  private fun createChecklistViewHolder(
      layoutInflater: LayoutInflater,
      parent: ViewGroup?
  ): ComicViewHolder {
    val loading = layoutInflater.inflate(R.layout.item_list, parent, false)
    return ComicViewHolder(loading)
  }

  override fun getItemCount(): Int = comicList.size

  override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
    holder.bind(comicList[position])
  }


}