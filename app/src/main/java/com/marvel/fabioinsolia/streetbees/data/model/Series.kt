package com.marvel.fabioinsolia.streetbees.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Series(

    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null

)
