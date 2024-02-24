package com.felipegandra.etholine.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.felipegandra.etholine.components.Header
import com.felipegandra.etholine.components.SliderComp
import com.felipegandra.etholine.services.calculate

@Composable
fun MainScreen() {

    var sliderValueGasoline by remember { mutableFloatStateOf(5.00f) }
    var sliderValueEthanol by remember { mutableFloatStateOf(3.00f) }

    var cardResultColor by remember { mutableStateOf(Color.White) }
    var cardResultFuel by remember { mutableStateOf("GASOLINA") }
    var cardResultCoef by remember { mutableFloatStateOf(0.0f) }
    var cardResultText by remember { mutableStateOf("Texto da escolha") }

    fun updateCardResult(){
        cardResultCoef = calculate(sliderValueGasoline, sliderValueEthanol)

        if (cardResultCoef > 0.70f)
        {
            cardResultColor = Color(0xFF9C27B0)
            cardResultFuel = "GASOLINA"
            cardResultText = "A diferença entre os valores é menor do que 30%."
        }
        else
        {
            cardResultColor = Color(0xFF008200)
            cardResultFuel = "ETANOL"
            cardResultText = "A diferença entre os valores é maior do que 30%."
        }
    }

    updateCardResult()


    Column {
        Column(modifier = Modifier.fillMaxSize()) {

            Header(
                text = "Ethorgas",
                textColor = Color(0xFF11293A),
                color = Color(0xFF2F77A7)
            )

            Column(Modifier.zIndex(2f)) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(horizontal = 24.dp)
                        .offset(y = (-20).dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
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
                        SliderComp(text = "Gasolina", sliderValue = sliderValueGasoline,
                            onChage = {
                                sliderValueGasoline = it
                                updateCardResult()
                        })

                        SliderComp(text = "Etanol", sliderValue = sliderValueEthanol,
                            onChage = {
                                sliderValueEthanol = it
                                updateCardResult()
                            })
                    }
                }

            }

            Column()
            {
                Card(
                    modifier = Modifier
                        .padding(24.dp)
                        .padding(bottom = 30.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    //colors = CardDefaults.cardColors(containerColor = cardResultColor),
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly) {

                        Column {
                            Text(text = "Escolha:", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 14.sp, modifier = Modifier.fillMaxWidth())
                            Text(color = cardResultColor, text = cardResultFuel, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 48.sp, modifier = Modifier.fillMaxWidth())
                        }

                        Column {
                            Text(
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                modifier = Modifier.fillMaxWidth(),
                                text = "Coeficiente:"
                            )
                            Text(
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                modifier = Modifier.fillMaxWidth(),
                                text = String.format("%.2f", cardResultCoef)
                            )
                        }

                        Row(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                            Text(
                                text = cardResultText,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.Justify,
                                fontSize = 12.sp
                            )
                        }




                    }

                }
            }
        }

    }

    }





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}