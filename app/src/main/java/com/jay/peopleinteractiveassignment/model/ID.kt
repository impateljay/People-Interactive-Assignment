package com.jay.peopleinteractiveassignment.model

import com.google.gson.annotations.SerializedName

data class ID(
        @SerializedName("name") val name:String,
        @SerializedName("value") val value:String?
)