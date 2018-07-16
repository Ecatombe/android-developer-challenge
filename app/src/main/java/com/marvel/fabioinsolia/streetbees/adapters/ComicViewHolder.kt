package com.marvel.fabioinsolia.streetbees.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.marvel.fabioinsolia.streetbees.data.model.Result
import kotlinx.android.synthetic.main.item_list.view.comicImage
import kotlinx.android.synthetic.main.item_list.view.comicTitle

class ComicViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  lateinit var comic: Result private set

  fun bind(comic: Result) {
    itemView.comicTitle.text = comic.title
    var thumb = comic.thumbnail?.path
    // /portrait_xlarge.jpg va aggiunto alla fine dell url
    Glide.with(itemView.context)
        .load(thumb + "/portrait_xlarge.jpg")
        .into(itemView.comicImage);
  }

}
