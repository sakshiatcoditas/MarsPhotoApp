package com.example.marsphotocomposeapi.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marsphotocomposeapi.MarsUiState

@Composable
fun HomeScreen(
    marsUiState: MarsUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (marsUiState) {
        is MarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is MarsUiState.Success -> PhotosGridScreen(
            marsUiState.photos, contentPadding = contentPadding, modifier = modifier.fillMaxWidth()
        )
        is MarsUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
    }
}