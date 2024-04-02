package com.felipegandra.ethor.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.ethor.services.diference
import com.felipegandra.ethor.ui.theme.KanitBold
import com.felipegandra.ethor.ui.theme.KanitExtraBold
import com.felipegandra.ethor.ui.theme.KanitRegular

@Composable
fun ResultComponent(
    modifier: Modifier = Modifier,
    cardResultFuel: String,
    coefficient : Float,
) {
    Column (modifier = modifier, verticalArrangement = Arrangement.Bottom){
        Text(
            modifier = Modifier.fillMaxWidth().offset( y= 25.dp),
            color = Color.Black,
            text = "Melhor escolha:",
            fontFamily = KanitBold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            text = cardResultFuel,
            fontFamily = KanitExtraBold,
            textAlign = TextAlign.Center,
            fontSize = 64.sp,
        )
        Text(
            modifier = Modifier.fillMaxWidth().offset(y = (-25).dp),
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontFamily = KanitRegular,
            fontSize = 14.sp,
            text = "( ≠ ${diference(coefficient)} )"
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ResultCompPreview() {
    ResultComponent(cardResultFuel = "GASOLINA", coefficient = 0.84F)
}