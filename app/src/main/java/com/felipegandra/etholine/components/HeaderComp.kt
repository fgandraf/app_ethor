package com.felipegandra.etholine.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipegandra.etholine.ui.theme.ProtestGuerrilla

@Composable
fun Header(text:String, textColor: Color, color:Color) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .background(color),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Text(
            text = text,
            fontSize = 46.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = ProtestGuerrilla,
            color = textColor,
            letterSpacing = 4.sp
        )
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header(
        text = "Etholine",
        textColor = Color(0xFF11293A),
        color = Color(0xFF2F77A7)
    )
}