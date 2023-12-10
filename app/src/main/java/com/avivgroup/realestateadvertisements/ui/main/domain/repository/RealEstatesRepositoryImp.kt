package com.avivgroup.realestateadvertisements.ui.main.domain.repository

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import com.avivgroup.realestateadvertisements.ui.main.data.remote.RealEstatesRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RealEstatesRepositoryImp(
    private val remoteDataSource: RealEstatesRemoteDataSource,
) : RealEstatesRepository {
    override suspend fun getRealEstatesAdvertisements(): Flow<RealEstateAdvertisementsResponse> =
        flow {
            emit(remoteDataSource.getRealEstateAdvertisements())
        }.flowOn(Dispatchers.IO)

    override suspend fun getRealEstateDetails(realEstateId: Int): Flow<RealEstateAdvertisement> =
        flow {
            emit(remoteDataSource.getRealEstateDetails(realEstateId = realEstateId))
        }.flowOn(Dispatchers.IO)
}