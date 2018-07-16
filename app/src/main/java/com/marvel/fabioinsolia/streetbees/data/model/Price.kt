package com.marvel.fabioinsolia.streetbees.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Price(
    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("price")
    @Expose
    var price: Float? = null
)
