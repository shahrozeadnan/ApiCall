package com.example.apicall.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicall.domain.GetGames
import com.example.apicall.domain.item.GameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val getGames: GetGames): ViewModel(){

    private val _games= MutableStateFlow(emptyList<GameItem>())
    val games: StateFlow<List<GameItem>> get()=_games

    init {
        getgames()

    }
    private fun getgames()
    {
        viewModelScope.launch {
            try {
             val games= getGames()
                _games.value= games

            }catch (_: Exception)
            {}
        }
    }

}