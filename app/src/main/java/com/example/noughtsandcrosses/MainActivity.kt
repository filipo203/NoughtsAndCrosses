package com.example.noughtsandcrosses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.noughtsandcrosses.modelViewViewModel.ViewModel
import com.example.noughtsandcrosses.ui.GameScreen
import com.example.noughtsandcrosses.ui.theme.NoughtsAndCrossesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoughtsAndCrossesTheme {
                val viewModel = ViewModel()
                GameScreen(viewModel)
            }
        }
    }
}

