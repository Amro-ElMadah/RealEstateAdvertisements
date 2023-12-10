package com.avivgroup.realestateadvertisements.ui.main.domain.repository

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import com.avivgroup.realestateadvertisements.ui.main.data.remote.RealEstatesRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RealEstatesRepositoryImp(
    private val remoteDataSource: RealEstatesRemoteDataSource,
) : RealEstatesRepository {
    override suspend fun getRealEstatesAdvertisements(): Flow<RealEstateAdvertisementsResponse> =
        flow {
            emit(remoteDataSource.getRealEstateAdvertisements())
        }

    override suspend fun getRealEstateDetails(realEstateId: Int): Flow<RealEstateAdvertisement> =
        flow {
            emit(remoteDataSource.getRealEstateDetails(realEstateId = realEstateId))
        }
}