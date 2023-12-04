package com.example.apicall.repo

import com.example.apicall.data.remote.GameService
import com.example.apicall.domain.item.GameItem
import com.example.apicall.domain.item.toGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService){

    suspend fun getGames():List<GameItem>
    {
        return gameService.getGames().map {
            it.toGameItem()
        }
    }

}