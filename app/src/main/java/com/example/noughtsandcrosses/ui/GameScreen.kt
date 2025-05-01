package com.example.noughtsandcrosses.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noughtsandcrosses.modelViewViewModel.ViewModel

@Composable
fun GameScreen(viewModel: ViewModel) {
    val board by viewModel.board
    val currentPlayer by viewModel.currentPlayer
    val winner by viewModel.winner

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = when (winner) {
                null -> "Player $currentPlayer's turn"
                "Draw" -> "It's a Draw!"
                else -> "$currentPlayer's Win!"
            },
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        for (i in 0..2) {
            Row {
                for (j in 0..2) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .border(2.dp, Color.Black)
                            .clickable { viewModel.makeMove(i, j) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(board[i][j], fontSize = 36.sp)
                    }
                }
            }
        }

        if (winner != null) {
            Button(
                onClick = { viewModel.resetGame() },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text("Restart")
            }
        }
    }
}
