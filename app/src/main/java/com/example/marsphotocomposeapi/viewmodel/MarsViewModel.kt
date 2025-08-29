package com.example.marsphotocomposeapi.viewmodel

import retrofit2.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
//import com.example.marsphotocomposeapi.MarsPhotosApplication
//import com.example.marsphotocomposeapi.data.repository.MarsPhotosRepository
import kotlinx.coroutines.launch
import java.io.IOException
import com.example.marsphotocomposeapi.MarsUiState
import com.example.marsphotocomposeapi.MarsPhotosApplication
import com.example.marsphotocomposeapi.data.repository.MarsPhotosRepository
import com.example.marsphotocomposeapi.model.MarsPhoto




class MarsViewModel(private val marsPhotosRepository: MarsPhotosRepository) : ViewModel() {

    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set


    init {
        getMarsPhotos()
    }



    fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = MarsUiState.Loading
            marsUiState = try {
                MarsUiState.Success(marsPhotosRepository.getMarsPhotos())
            } catch (e: IOException) {
                MarsUiState.Error
            } catch (e: HttpException) {
                MarsUiState.Error
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository = marsPhotosRepository)
            }
        }
    }
}
