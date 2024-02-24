package com.felipegandra.etholine.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.etholine.ui.theme.IndieFlower

@Composable
fun SliderComp(
    text: String,
    sliderValue: Float,
    onChage: (Float) -> Unit
)
{
    Row(modifier = Modifier.fillMaxWidth())
    {
        Column()
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    fontFamily = IndieFlower,
                    color = Color(0xFF11293A)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "R$ ${String.format("%.2f", sliderValue)}",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textAlign = TextAlign.End,
                    color = Color(0xFF11293A)
                )
            }


            Slider(
                modifier = Modifier.fillMaxWidth(),
                valueRange = 1.00f..10.00f,
                value = sliderValue,
                onValueChange = onChage
            )


        }
    }
}