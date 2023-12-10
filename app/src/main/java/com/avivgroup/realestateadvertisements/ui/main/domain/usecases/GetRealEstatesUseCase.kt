package com.avivgroup.realestateadvertisements.ui.main.domain.usecases

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import com.avivgroup.realestateadvertisements.ui.main.domain.repository.RealEstatesRepository
import kotlinx.coroutines.flow.Flow

class GetRealEstatesUseCase(private val repository: RealEstatesRepository) {
    suspend fun build(): Flow<RealEstateAdvertisementsResponse> =
        repository.getRealEstatesAdvertisements()
}