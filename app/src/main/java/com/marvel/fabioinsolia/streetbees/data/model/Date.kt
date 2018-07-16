package com.marvel.fabioinsolia.streetbees.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Date(
    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("date")
    @Expose
    var date: String? = null
)



