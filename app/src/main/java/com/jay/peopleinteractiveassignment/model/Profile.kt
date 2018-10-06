package com.jay.peopleinteractiveassignment.model

import com.google.gson.annotations.SerializedName

data class Profile(
        @SerializedName("gender") val gender: String,
        @SerializedName("name") val name: Name,
        @SerializedName("location") val location: Location,
        @SerializedName("email") val email: String,
        @SerializedName("login") val login: Login,
        @SerializedName("dob") val dob: DOB,
        @SerializedName("registered") val registered: Registered,
        @SerializedName("details") val phone: String,
        @SerializedName("cell") val cell: String,
        @SerializedName("id") val id: ID,
        @SerializedName("picture") val picture: Picture,
        @SerializedName("nat") val nat: String
)