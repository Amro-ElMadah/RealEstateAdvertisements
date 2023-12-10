package com.avivgroup.realestateadvertisements.data.remote.network.retrofit

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import retrofit2.http.GET

interface RealEstateAdvertisementsAPI {

    @GET("listings.json")
    suspend fun loadRealEstateAdvertisements(): RealEstateAdvertisementsResponse
}