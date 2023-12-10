package com.avivgroup.realestateadvertisements.ui.main.domain.usecases

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.ui.main.domain.repository.RealEstatesRepository
import kotlinx.coroutines.flow.Flow

class GetRealEstateDetailsUseCase(private val repository: RealEstatesRepository) {
    suspend fun build(realEstateId: Int): Flow<RealEstateAdvertisement> =
        repository.getRealEstateDetails(realEstateId)
}