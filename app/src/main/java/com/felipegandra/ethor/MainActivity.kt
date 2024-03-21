package com.felipegandra.ethor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.felipegandra.ethor.components.BannerAd
import com.felipegandra.ethor.screens.HomeScreen
import com.felipegandra.ethor.ui.theme.EthorTheme
import com.google.android.gms.ads.MobileAds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileAds.initialize(this)
            EthorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
                        HomeScreen()
                        BannerAd(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter), adId = "ca-app-pub-5289869298823373/4495872454")
                    }
                }
            }
        }
    }
}
