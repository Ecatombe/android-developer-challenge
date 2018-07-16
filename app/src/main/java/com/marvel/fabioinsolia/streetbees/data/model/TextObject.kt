package com.marvel.fabioinsolia.streetbees.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class TextObject(

    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("language")
    @Expose
    var language: String? = null,
    @SerializedName("text")
    @Expose
    var text: String? = null

)
