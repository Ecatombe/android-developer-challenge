package com.marvel.fabioinsolia.streetbees.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Stories (

  @SerializedName("available")
  @Expose
  var available: Int? = null,
  @SerializedName("collectionURI")
  @Expose
  var collectionURI: String? = null,
  @SerializedName("items")
  @Expose
  var items: List<Item_>? = null,
  @SerializedName("returned")
  @Expose
  var returned: Int? = null

)