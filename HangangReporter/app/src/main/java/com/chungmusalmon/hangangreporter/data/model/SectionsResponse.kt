package com.chungmusalmon.hangangreporter.data.model

import com.google.gson.annotations.SerializedName

data class SectionsResponse(
    @SerializedName("result")
    var result : Int,
    @SerializedName("data")
    var data : ArrayList<Section>
){
    data class Section(
        @SerializedName("registeredCameras")
        var registeredCameras : ArrayList<String>,
        @SerializedName("_id")
        var id : String,
        @SerializedName("description")
        var description : String,
        @SerializedName("totalArea")
        var totalArea : Long,
        @SerializedName("invalidArea")
        var invalidArea : Long,
        @SerializedName("centerLatitude")
        var centerLatitude : Double,
        @SerializedName("centerLongitude")
        var centerLongitude : Double,
        @SerializedName("createdAt")
        var createdAt : String,
        @SerializedName("__v")
        var __v : Int
    )
}
