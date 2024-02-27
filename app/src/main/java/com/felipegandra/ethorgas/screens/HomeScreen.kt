package com.felipegandra.ethorgas.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.ethorgas.R
import com.felipegandra.ethorgas.components.SliderComp
import com.felipegandra.ethorgas.services.calculate
import com.felipegandra.ethorgas.services.diference
import com.felipegandra.ethorgas.ui.theme.KanitBold
import com.felipegandra.ethorgas.ui.theme.KanitExtraBold
import com.felipegandra.ethorgas.ui.theme.KanitRegular

@Composable
fun HomeScreen() {
    val colorGreen = Color(0xFF00AA00)
    val colorRed = Color(0xFFC80000)

    var sliderValueGasoline by remember { mutableFloatStateOf(5.00f) }
    var sliderValueEthanol by remember { mutableFloatStateOf(3.00f) }
    var gasolineTextColor by remember { mutableStateOf(Color.Black) }
    var ethanolTextColor by remember { mutableStateOf(Color.Black) }
    var gasolineSliderColor by remember { mutableStateOf(Color.Red) }
    var ethanolSliderColor by remember { mutableStateOf(Color.Red) }
    var background by remember { mutableIntStateOf(1) }
    var cardResultFuel by remember { mutableStateOf("GASOLINA") }
    var coefficient by remember { mutableFloatStateOf(0.0f) }

    fun updateCardResult() {
        coefficient = calculate(sliderValueGasoline, sliderValueEthanol)

        if (coefficient > 0.70f) {
            gasolineTextColor = colorGreen
            ethanolTextColor = colorRed
            gasolineSliderColor = colorGreen
            ethanolSliderColor = colorRed
            cardResultFuel = "GASOLINA"
            background = R.drawable.gasoline
        } else {
            gasolineTextColor = colorRed
            ethanolTextColor = colorGreen
            ethanolSliderColor = colorGreen
            gasolineSliderColor = colorRed
            background = R.drawable.etanol
            cardResultFuel = "ETANOL"
        }
    }

    updateCardResult()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .paint(painterResource(id = background), contentScale = ContentScale.FillBounds),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Column(modifier = Modifier.padding(bottom = 40.dp)
                )
                {
                    Text(
                        color = Color.Black,
                        text = "Melhor escolha:",
                        fontFamily = KanitBold,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(modifier = Modifier.offset(y = (-15).dp)) {
                        Text(
                            color = Color.Black,
                            text = cardResultFuel,
                            fontFamily = KanitExtraBold,
                            textAlign = TextAlign.Center,
                            fontSize = 64.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .offset(y = (-30).dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = BorderStroke(1.dp, Color.LightGray)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                )
                {
                    SliderComp(text = "GASOLINA", sliderValue = sliderValueGasoline, textColor = gasolineTextColor, sliderColor = gasolineSliderColor,
                        onChange = {
                            sliderValueGasoline = it
                            updateCardResult()
                        })

                    Spacer(modifier = Modifier.height(14.dp))


                    SliderComp(text = "ETANOL", sliderValue = sliderValueEthanol, textColor = ethanolTextColor, sliderColor = ethanolSliderColor,
                        onChange = {
                            sliderValueEthanol = it
                            updateCardResult()
                        })


                    Text(
                        textAlign = TextAlign.End,
                        fontFamily = KanitRegular,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth(),
                        text = "DIFERENÇA: ${diference(coefficient)}"
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}