package com.avivgroup.realestateadvertisements.ui.main.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.data.remote.network.response.Response
import com.avivgroup.realestateadvertisements.ui.main.domain.usecases.GetRealEstatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RealEstatesViewModel @Inject constructor(
    private val getRealEstatesUseCase: GetRealEstatesUseCase,
) : ViewModel() {
    private val _realEstates =
        MutableStateFlow<Response<List<RealEstateAdvertisement>?>>(Response.Loading(true))
    val realEstates get() = _realEstates.asStateFlow()

    fun loadRealEstates() {
        viewModelScope.launch {
            getRealEstatesUseCase.build()
                .onStart {
                    _realEstates.emit(Response.Loading(true))
                }
                .catch {
                    _realEstates.emit(Response.Error(it))
                }
                .collect {
                    _realEstates.emit(Response.Success(it.items))
                }
        }
    }
}