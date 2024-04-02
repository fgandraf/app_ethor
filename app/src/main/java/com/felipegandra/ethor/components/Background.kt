package com.felipegandra.ethor.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipegandra.ethor.R

@Composable
fun Background(
    backgroundId : Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 40.dp)
            .paint(painterResource(id = backgroundId), contentScale = ContentScale.Crop),
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun BackgroundPreview() {
    Background(backgroundId = R.drawable.gasoline)
}