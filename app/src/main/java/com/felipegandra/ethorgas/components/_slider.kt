package com.felipegandra.ethorgas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.ethorgas.ui.theme.KanitMedium

@Composable
fun SliderComp(
    text: String,
    sliderValue: Float,
    textColor: Color,
    sliderColor: Color,
    onChange: (Float) -> Unit
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
                Text(modifier = Modifier.offset(y = 15.dp),
                    text = text,
                    fontSize = 20.sp,
                    fontFamily = KanitMedium,
                    color = textColor
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 15.dp),
                    text = "R$ ${String.format("%.2f", sliderValue)}",
                    fontSize = 18.sp,
                    fontFamily = KanitMedium,
                    textAlign = TextAlign.End,
                    color = textColor
                )
            }


            Slider(
                modifier = Modifier.fillMaxWidth(),
                valueRange = 1.00f..10.00f,
                value = sliderValue,
                onValueChange = onChange,
                colors = SliderDefaults.colors(
                    thumbColor = sliderColor,
                    activeTrackColor = sliderColor,
                    inactiveTrackColor = sliderColor
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SliderCompPreview() {
    SliderComp(text = "GASOLINA", sliderValue = 5.21f, textColor = Color.Red, sliderColor = Color.Red, onChange = {})
}