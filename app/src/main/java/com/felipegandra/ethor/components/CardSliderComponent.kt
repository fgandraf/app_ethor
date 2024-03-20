package com.felipegandra.ethor.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun CardSliderComponent(
    sliderValueGasoline : Float,
    sliderValueEthanol: Float,
    sliderGasolineOnChange: (Float) -> Unit,
    sliderEthanolOnChange: (Float) -> Unit,
    updateCard: () -> Unit,
    modifier: Modifier
) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(250.dp)
                .zIndex(2f)
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp)
                .offset(y = (-20).dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            )
            {
                SliderComp(text = "GASOLINA:", sliderValue = sliderValueGasoline,
                    onChange = {
                        sliderGasolineOnChange(it)
                        updateCard()
                    })

                Spacer(modifier = Modifier.height(10.dp))

                SliderComp(text = "ETANOL:", sliderValue = sliderValueEthanol,
                    onChange = {
                        sliderEthanolOnChange(it)
                        updateCard()
                    })
            }
        }

}

@Preview
@Composable
fun CardSliderComponentView() {
    CardSliderComponent(
        sliderValueGasoline = 5.31f,
        sliderValueEthanol = 3.45f,
        sliderGasolineOnChange = {},
        sliderEthanolOnChange = {},
        updateCard = {  },
        modifier = Modifier
    )
    
}