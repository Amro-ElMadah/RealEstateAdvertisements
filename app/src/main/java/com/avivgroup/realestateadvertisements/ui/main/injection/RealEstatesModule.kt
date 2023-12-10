package com.avivgroup.realestateadvertisements.ui.main.injection

import com.avivgroup.realestateadvertisements.data.remote.network.retrofit.RealEstateAdvertisementsAPI
import com.avivgroup.realestateadvertisements.ui.main.data.remote.RealEstatesRemoteDataSource
import com.avivgroup.realestateadvertisements.ui.main.domain.repository.RealEstatesRepository
import com.avivgroup.realestateadvertisements.ui.main.domain.repository.RealEstatesRepositoryImp
import com.avivgroup.realestateadvertisements.ui.main.domain.usecases.GetRealEstateDetailsUseCase
import com.avivgroup.realestateadvertisements.ui.main.domain.usecases.GetRealEstatesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
open class RealEstatesModule {

    @Provides
    fun provideRealEstatesRemoteDataSource(realEstateAdvertisementsAPI: RealEstateAdvertisementsAPI) =
        RealEstatesRemoteDataSource(realEstateAdvertisementsAPI = realEstateAdvertisementsAPI)

    @Provides
    fun provideRealEstatesRepository(
        remoteDataSource: RealEstatesRemoteDataSource,
    ): RealEstatesRepository =
        RealEstatesRepositoryImp(remoteDataSource)

    @Provides
    fun provideGetRealEstatesUseCase(repository: RealEstatesRepository) =
        GetRealEstatesUseCase(repository)

    @Provides
    fun provideGetRealEstateDetailsUseCase(repository: RealEstatesRepository) =
        GetRealEstateDetailsUseCase(repository)
}