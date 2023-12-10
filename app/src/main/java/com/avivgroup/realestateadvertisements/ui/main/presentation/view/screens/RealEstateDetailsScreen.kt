package com.avivgroup.realestateadvertisements.ui.main.presentation.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder
import com.avivgroup.realestateadvertisements.R.drawable
import com.avivgroup.realestateadvertisements.R.string
import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisement
import com.avivgroup.realestateadvertisements.data.remote.network.response.Response.Loading
import com.avivgroup.realestateadvertisements.data.remote.network.response.Response.Success
import com.avivgroup.realestateadvertisements.ui.main.presentation.viewmodel.RealEstatesViewModel

@Composable
fun RealEstateDetailsScreen(
    viewModel: RealEstatesViewModel,
    realEstateSelectedId: Int,
    onBackButtonPressed: () -> Unit,
) {
    val response by viewModel.details.collectAsState(initial = Loading(false))

    LaunchedEffect(true) {
        viewModel.loadRealEstateDetails(realEstateSelectedId)
    }
    when (response) {
        is Loading ->
            if (response.loading == true) {
                LoadingScreen()
            }

        is Success ->
            RealEstateDetails(
                realEstate = response.data!!,
                onBackButtonPressed
            )

        else -> if (response.throwable != null) {
            ErrorScreen(stringResource(id = string.network_error)) {
                viewModel.loadRealEstateDetails(realEstateId = realEstateSelectedId)
            }
        }
    }
}

@Composable
fun RealEstateDetails(
    realEstate: RealEstateAdvertisement,
    onBackButtonPressed: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        val painter =
            rememberAsyncImagePainter(
                Builder(LocalContext.current)
                    .data(data = realEstate.url)
                    .placeholder(drawable.ic_launcher_background)
                    .error(drawable.ic_launcher_foreground)
                    .build()
            )
        Box {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(MaterialTheme.colorScheme.surface),
                contentScale = ContentScale.Crop
            )

            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(all = 10.dp)
                    .clickable {
                        onBackButtonPressed.invoke()
                    },
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        realEstate.price?.let { price ->
            Text(
                text = stringResource(id = string.price, price),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
        realEstate.city?.let { city ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.city, city),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
        realEstate.area?.let { area ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.area_size, area),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
        realEstate.rooms?.let { rooms ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.number_of_rooms, rooms),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }

        realEstate.bedrooms?.let { bedrooms ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.number_of_bedrooms, bedrooms),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }

        realEstate.professional?.let { professional ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.professional, professional),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }

        realEstate.propertyType?.let { propertyType ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = string.property_type, propertyType),
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
    }
}