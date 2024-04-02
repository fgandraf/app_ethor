package com.felipegandra.ethor.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.ethor.BuildConfig
import com.felipegandra.ethor.components.Background
import com.felipegandra.ethor.components.CardSliderComponent
import com.felipegandra.ethor.components.ResultComponent
import com.felipegandra.ethor.services.updateResult
import com.felipegandra.ethor.ui.theme.EthorTheme

@Composable
fun HomeScreen()
{
    var sliderValueGasoline by remember { mutableFloatStateOf(5.0f) }
    var sliderValueEthanol by remember { mutableFloatStateOf(3.0f) }
    var background by remember { mutableIntStateOf(updateResult(sliderValueGasoline, sliderValueEthanol).third) }
    var cardResultFuel by remember { mutableStateOf(updateResult(sliderValueGasoline, sliderValueEthanol).second) }
    var coefficient by remember { mutableFloatStateOf(updateResult(sliderValueGasoline, sliderValueEthanol).first) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White))
    {


        Box(modifier = Modifier
            .fillMaxWidth()
            .height((LocalConfiguration.current.screenHeightDp - 200).dp)
            .align(Alignment.TopCenter)
        ){
            Background(
                backgroundId = background,
                modifier = Modifier
                    .fillMaxHeight()
            )

            ResultComponent(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = (-45).dp),
                cardResultFuel = cardResultFuel,
                coefficient = coefficient
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .offset(y = (-25).dp)
            .align(Alignment.BottomCenter)
        ){
            CardSliderComponent(
                modifier = Modifier
                    .fillMaxHeight(),
            sliderValueGasoline = sliderValueGasoline,
            sliderValueEthanol = sliderValueEthanol,
            sliderGasolineOnChange = {sliderValueGasoline = it},
            sliderEthanolOnChange =  {sliderValueEthanol = it},
            updateCard = {
                coefficient = updateResult(sliderValueGasoline, sliderValueEthanol).first
                cardResultFuel = updateResult(sliderValueGasoline, sliderValueEthanol).second
                background = updateResult(sliderValueGasoline, sliderValueEthanol).third
            } )
        }


        Text(modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(end = 28.dp),
            fontSize = 9.sp,
            color = Color.Black,
            text = "VERSÃO: ${BuildConfig.VERSION_NAME}"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EthorTheme {
        HomeScreen()
    }
}