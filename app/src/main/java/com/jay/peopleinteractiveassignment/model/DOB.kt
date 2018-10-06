package com.jay.peopleinteractiveassignment.model

import com.google.gson.annotations.SerializedName

data class DOB(
        @SerializedName("date") val date:String,
        @SerializedName("age") val age:Int
)