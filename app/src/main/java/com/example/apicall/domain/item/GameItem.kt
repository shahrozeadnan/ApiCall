package com.example.apicall.domain.item

import com.example.apicall.data.remote.model.GameModel

data class GameItem(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val developer: String,
)
fun GameModel.toGameItem()=GameItem(id,title,thumbnail,short_description,developer)

