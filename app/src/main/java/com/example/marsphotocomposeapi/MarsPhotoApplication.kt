package com.example.marsphotocomposeapi

import android.app.Application
import com.example.marsphotocomposeapi.data.repository.AppContainer
import com.example.marsphotocomposeapi.data.repository.DefaultAppContainer


class MarsPhotosApplication : Application() {
    val container: AppContainer by lazy { DefaultAppContainer() }


}
