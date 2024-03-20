package com.felipegandra.ethor.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.ethor.services.diference
import com.felipegandra.ethor.ui.theme.KanitBold
import com.felipegandra.ethor.ui.theme.KanitExtraBold
import com.felipegandra.ethor.ui.theme.KanitRegular

@Composable
fun ResultComponent(
    backgroundId : Int,
    cardResultFuel: String,
    coefficient : Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((LocalConfiguration.current.screenHeightDp - 230).dp)
            .padding(top = 40.dp)
            .paint(painterResource(id = backgroundId), contentScale = ContentScale.FillBounds),
        contentAlignment = Alignment.BottomCenter
    )
    {
        Column(modifier = Modifier.padding(bottom = 45.dp))
        {
            Row(modifier = Modifier.offset(y = (15).dp)) {
                Text(
                    color = Color.Black,
                    text = "Melhor escolha:",
                    fontFamily = KanitBold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row {
                Text(
                    color = Color.Black,
                    text = cardResultFuel,
                    fontFamily = KanitExtraBold,
                    textAlign = TextAlign.Center,
                    fontSize = 64.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(modifier = Modifier.offset(y = (-10).dp)) {
                Text(
                    textAlign = TextAlign.Center,
                    fontFamily = KanitRegular,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth(),
                    text = "( ≠ ${diference(coefficient)} )"
                )
            }
        }
    }
}