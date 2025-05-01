package com.example.noughtsandcrosses.modelViewViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class ViewModel : ViewModel() {
    var board = mutableStateOf(List(3) { List(3) { "" } })
        private set

    var currentPlayer = mutableStateOf("O")
        private set

    var winner = mutableStateOf<String?>(null)
        private set

    fun makeMove(row: Int, col: Int) {
        if (board.value[row][col] == "" && winner.value == null) {
            val newBoard = board.value.map { it.toMutableList() }.toMutableList()
            newBoard[row][col] = currentPlayer.value
            board.value = newBoard.map { it.toList() }

            if (checkWin(currentPlayer.value)) {
                winner.value = currentPlayer.value
            } else if (isBoardFull()) {
                winner.value = "Draw"
            } else {
                currentPlayer.value = if (currentPlayer.value == "O") "X" else "O"
            }
        }
    }

    fun resetGame() {
        board.value = List(3) { List(3) { "" } }
        currentPlayer.value = "O"
        winner.value = null
    }

    private fun isBoardFull(): Boolean =
        board.value.flatten().none { it == "" }

    private fun checkWin(player: String): Boolean {
        val b = board.value
        return (0..2).any { i -> b[i].all { it == player } || b.all { it[i] == player } } ||
                (0..2).all { i -> b[i][i] == player } ||
                (0..2).all { i -> b[i][2 - i] == player }
    }
}
