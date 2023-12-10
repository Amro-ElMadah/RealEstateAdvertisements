package com.avivgroup.realestateadvertisements.ui.main.domain.repository

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import kotlinx.coroutines.flow.Flow

interface RealEstatesRepository {
    suspend fun getRealEstatesAdvertisements(): Flow<RealEstateAdvertisementsResponse>

    suspend fun getRealEstateDetails(realEstateId: Int): Flow<RealEstateAdvertisement>
}