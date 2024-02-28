package com.felipegandra.ethorgas.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.felipegandra.ethorgas.components.CardSliderComponent
import com.felipegandra.ethorgas.components.ResultComponent
import com.felipegandra.ethorgas.services.updateResult
import com.felipegandra.ethorgas.ui.theme.EthorgasTheme

@Composable
fun HomeScreen()
{
    var sliderValueGasoline by remember { mutableFloatStateOf(5.0f) }
    var sliderValueEthanol by remember { mutableFloatStateOf(3.0f) }
    var background by remember { mutableIntStateOf(updateResult(sliderValueGasoline, sliderValueEthanol).third) }
    var cardResultFuel by remember { mutableStateOf(updateResult(sliderValueGasoline, sliderValueEthanol).second) }
    var coefficient by remember { mutableFloatStateOf(updateResult(sliderValueGasoline, sliderValueEthanol).first) }

    Box(modifier = Modifier.fillMaxSize())
    {

        ResultComponent(
            backgroundId = background,
            cardResultFuel = cardResultFuel,
            coefficient = coefficient )


        CardSliderComponent(
            modifier = Modifier.align(Alignment.BottomCenter),
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
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EthorgasTheme {
        HomeScreen()
    }
}