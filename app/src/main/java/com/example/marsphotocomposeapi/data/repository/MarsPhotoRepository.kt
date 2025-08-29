package com.example.marsphotocomposeapi.data.repository

import com.example.marsphotocomposeapi.model.MarsPhoto
import com.example.marsphotocomposeapi.network.MarsApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface MarsPhotosRepository {
    /** Fetches list of MarsPhoto from marsApi */
    suspend fun getMarsPhotos(): List<MarsPhoto>
}


class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> =
        marsApiService.getPhotos() ?: emptyList()
}

