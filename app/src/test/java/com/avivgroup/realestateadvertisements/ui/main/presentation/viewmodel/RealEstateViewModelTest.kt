package com.avivgroup.realestateadvertisements.ui.main.presentation.viewmodel

import com.avivgroup.realestateadvertisements.utils.FakeRealEstatesListData.realEstateAdvertisementsResponse
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import com.avivgroup.realestateadvertisements.data.remote.network.response.Response
import com.avivgroup.realestateadvertisements.ui.main.domain.usecases.GetRealEstateDetailsUseCase
import com.avivgroup.realestateadvertisements.ui.main.domain.usecases.GetRealEstatesUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class RealEstateViewModelTest {

    private lateinit var viewModel: RealEstatesViewModel
    private lateinit var getRealEstatesUseCase: GetRealEstatesUseCase
    private lateinit var getRealEstateDetailsUseCase: GetRealEstateDetailsUseCase

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        getRealEstatesUseCase = mockk()
        getRealEstateDetailsUseCase = mockk()
        viewModel = RealEstatesViewModel(getRealEstatesUseCase, getRealEstateDetailsUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `given success response with empty list when call load real estate list then the realEstates success with empty list`() =
        runBlocking {
            // Given
            val fakeListings = RealEstateAdvertisementsResponse(emptyList(), 0)
            coEvery { getRealEstatesUseCase.build() } returns flowOf(fakeListings)

            // When
            viewModel.loadRealEstates()

            // Then
            assert(viewModel.realEstates.value.data.isNullOrEmpty())
        }

    @Test
    fun `given success response with non empty list when call load real estate list then the realEstates success with the same list`() =
        runBlocking {
            // Given
            val fakeListings = realEstateAdvertisementsResponse
            coEvery { getRealEstatesUseCase.build() } returns flowOf(fakeListings)

            // When
            viewModel.loadRealEstates()

            // Then
            assert(viewModel.realEstates.value.data == fakeListings.items)
        }

    @Test
    fun `given error response when call load real estate list then the realEstates error`() =
        runBlocking {
            // Given
            val fakeError = Exception("Fake list error")
            coEvery { getRealEstatesUseCase.build() } returns flow {
                throw fakeError
            }

            // When
            viewModel.loadRealEstates()

            // Then
            assert(viewModel.realEstates.value is Response.Error)
        }

    @Test
    fun `given success response when call load real estate details then the details value is success with the real estate value`() = runBlocking {
        // Given
        val fakeDetails = realEstateAdvertisementsResponse.items!![0]
        val realEstateId = 1
        coEvery { getRealEstateDetailsUseCase.build(realEstateId) } returns flowOf(fakeDetails)

        // When
        viewModel.loadRealEstateDetails(realEstateId)

        // Then
        assert(viewModel.details.value.data == fakeDetails)
    }

    @Test
    fun `given error response when call load real estate details then the details value is error`() =
        runBlocking {
            // Given
            val fakeError = Exception("Fake details error")
            val realEstateId = 1
            coEvery { getRealEstateDetailsUseCase.build(realEstateId) } returns flow {
                throw fakeError
            }

            // When
            viewModel.loadRealEstateDetails(realEstateId)

            // Then
            assert(viewModel.details.value is Response.Error)
        }
}
