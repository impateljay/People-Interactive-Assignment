package com.jay.peopleinteractiveassignment.model

import com.google.gson.annotations.SerializedName

data class Location(
        @SerializedName("street") val street: String,
        @SerializedName("city") val city: String,
        @SerializedName("state") val state: String,
        @SerializedName("postcode") val postcode: String,
        @SerializedName("coordinates") val coordinates: Coordinates,
        @SerializedName("timezone") val timezone: Timezone
)