package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // We call our new App function here
                    ArtSpaceApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var currentArtworkId by remember { mutableStateOf(1) }

    // 1. Determine which image to show based on the ID
    val imageResource = when (currentArtworkId) {
        1 -> R.drawable.ft_dongu
        2 -> R.drawable.ft_gurur
        3 -> R.drawable.ft_monalisa
        else -> R.drawable.ic_launcher_foreground
    }

    val title = when (currentArtworkId) {
        1 -> "Still Life of Blue Rose and Other Flowers"
        2 -> "Sailing Under the Bridge"
        3 -> "The Starry Night"
        else -> "Unknown"
    }

    val artist = when (currentArtworkId) {
        1 -> "Owen Scott (2021)"
        2 -> "Kat Kuan (2017)"
        3 -> "Vincent van Gogh (1889)"
        else -> "Unknown"
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Section A: The Image area
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Added Surface for the "border" effect
            androidx.compose.material3.Surface(
                shadowElevation = 8.dp, // This gives it the "floating" shadow look
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = title,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // Section B: The Text (Descriptor)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title)
            Text(text = artist)
        }

        // Section C: Buttons
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { currentArtworkId = if (currentArtworkId == 1) 3 else currentArtworkId - 1 }) {
                Text("Previous")
            }
            Button(onClick = { currentArtworkId = if (currentArtworkId == 3) 1 else currentArtworkId + 1 }) {
                Text("Next")
            }
        }
    }
}