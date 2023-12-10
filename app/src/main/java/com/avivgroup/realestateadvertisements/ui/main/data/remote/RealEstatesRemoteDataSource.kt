package com.avivgroup.realestateadvertisements.ui.main.data.remote

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import com.avivgroup.realestateadvertisements.data.remote.network.retrofit.RealEstateAdvertisementsAPI

class RealEstatesRemoteDataSource(private val realEstateAdvertisementsAPI: RealEstateAdvertisementsAPI) {

    suspend fun getRealEstateAdvertisements(): RealEstateAdvertisementsResponse =
        realEstateAdvertisementsAPI.loadRealEstateAdvertisements()
}