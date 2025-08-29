package com.example.marsphotocomposeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Modifier

import com.example.marsphotocomposeapi.ui.theme.MarsPhotoComposeApiTheme

import androidx.compose.material3.Surface

import com.example.marsphotocomposeapi.screens.MarsPhotosApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MarsPhotoComposeApiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MarsPhotosApp()
                }
            }
        }
    }
}
