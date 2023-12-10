package com.avivgroup.realestateadvertisements.data.remote.network.retrofit

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RealEstateAdvertisementsAPI {

    @GET("listings.json")
    suspend fun loadRealEstateAdvertisements(): RealEstateAdvertisementsResponse

    @GET("listings/{listingId}.json")
    suspend fun getRealEstateDetails(@Path("listingId") listingId: Int): RealEstateAdvertisement

}