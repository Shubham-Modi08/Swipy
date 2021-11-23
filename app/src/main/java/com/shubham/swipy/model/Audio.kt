package com.shubham.swipy.model

// Contains the data we want to show on UI
data class Audio(
    val shortID: Int,
    val title: String,
    val dateCreated: String,
    val audioPath: String,
    val creator: Creator,
    var curPos:Int = 0
)