package com.example.marsphotocomposeapi

import com.example.marsphotocomposeapi.model.MarsPhoto





sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}
