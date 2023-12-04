package com.example.apicall.domain

import com.example.apicall.domain.item.GameItem
import com.example.apicall.repo.GameRepository
import javax.inject.Inject

class GetGames @Inject constructor(private val gameRepository: GameRepository){
    suspend operator fun invoke(): List<GameItem>
    {
        return gameRepository.getGames().shuffled()
    }
}