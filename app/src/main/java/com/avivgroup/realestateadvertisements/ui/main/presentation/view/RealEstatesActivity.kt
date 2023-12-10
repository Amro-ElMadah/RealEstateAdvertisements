package com.avivgroup.realestateadvertisements.ui.main.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.avivgroup.realestateadvertisements.ui.main.presentation.view.screens.RealEstateListScreen
import com.avivgroup.realestateadvertisements.ui.main.presentation.viewmodel.RealEstatesViewModel
import com.avivgroup.realestateadvertisements.ui.theme.RealEstateAdvertisementsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

@AndroidEntryPoint
class RealEstatesActivity : ComponentActivity(), CoroutineScope by MainScope() {
    private val viewModel: RealEstatesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RealEstateAdvertisementsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RealEstateListScreen(viewModel) { realEstate ->
                        // Todo : Implement the real estate click.
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
