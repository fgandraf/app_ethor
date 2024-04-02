package com.felipegandra.ethor.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.felipegandra.ethor.ui.theme.KanitBold
import com.felipegandra.ethor.ui.theme.KanitMedium
import com.felipegandra.ethor.ui.theme.KanitRegular

@Composable
fun SliderComp(
    text: String,
    sliderValue: Float,
    onChange: (Float) -> Unit
)
{
    Row(modifier = Modifier.fillMaxWidth())
    {
        Column()
        {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 10.dp),
                        text = text,
                        fontSize = 14.sp,
                        fontFamily = KanitBold,
                        color = Color.DarkGray,
                    )
                    Text(
                        modifier = Modifier
                            .width(100.dp)
                            .align(Alignment.BottomCenter),
                        text = "R$ ${String.format("%.2f", sliderValue)}",
                        textAlign = TextAlign.Start,
                        fontSize = 22.sp,
                        fontFamily = KanitMedium,
                        color = Color(0xFF8160B9)
                    )
                }



            Row(modifier = Modifier
                .height(66.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically)
            {
                Row(modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clickable { onChange(sliderValue - 0.01f) },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.offset(y = (-12).dp),
                        text = "-",
                        fontSize = 45.sp,
                        fontFamily = KanitRegular,
                        color = Color(0xFF8160b9),
                        textAlign = TextAlign.Center
                    )
                }

                Slider(modifier = Modifier.fillMaxWidth(0.86f),
                    valueRange = 1.00f..10.00f,
                    steps = 89,
                    value = sliderValue,
                    onValueChange = onChange,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF8160b9),
                        activeTrackColor = Color(0xFF8160b9),
                        inactiveTrackColor = Color(0x668160B9)
                    )
                )
                Row(modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .clickable { onChange(sliderValue + 0.01f) },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.offset(y = (-12).dp),
                        text = "+",
                        fontSize = 45.sp,
                        fontFamily = KanitRegular,
                        color = Color(0xFF8160b9),
                        textAlign = TextAlign.Center
                    )
                }
            }







        }
    }
}


@Preview(showBackground = true)
@Composable
fun SliderCompPreview() {
    SliderComp(text = "GASOLINA", sliderValue = 5.21f, onChange = {})
}