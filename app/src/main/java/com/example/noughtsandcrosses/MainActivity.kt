package com.example.noughtsandcrosses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.noughtsandcrosses.modelViewViewModel.ViewModel
import com.example.noughtsandcrosses.ui.GameScreen
import com.example.noughtsandcrosses.ui.theme.NoughtsAndCrossesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ViewModel by viewModels()
        setContent {
            var isDarkTheme by rememberSaveable { mutableStateOf(false) }
            val sugarSnow = FontFamily(Font(R.font.sugar_snow))

            NoughtsAndCrossesTheme(isDarkTheme) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                if (isDarkTheme) "Dark Mode" else "Light Mode",
                                fontFamily = sugarSnow
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Switch(
                                checked = isDarkTheme,
                                onCheckedChange = { isDarkTheme = it }
                            )
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    GameScreen(viewModel, sugarSnow)
                }
            }
        }
    }
}

