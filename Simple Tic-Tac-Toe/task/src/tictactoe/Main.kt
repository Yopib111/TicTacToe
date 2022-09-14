package tictactoe

import kotlin.math.absoluteValue

val ticTac = arrayOf(
    charArrayOf('_', '_', '_'),
    charArrayOf('_', '_', '_'),
    charArrayOf('_', '_', '_'))

fun main() {

    cellPrint()
    var move = ""
    val regex = Regex(pattern = "[1-3] [1-3]")
    var breaking = 0
    val finish = 0

    do {
        do {
            move = readln()
            if (move[0].isDigit() && move[2].isDigit() && (move[0].digitToInt() == 0 || move[0].digitToInt() > 3 ||
                        move[2].digitToInt() == 0 || move[2].digitToInt() > 3)
            ) {
                println("Coordinates should be from 1 to 3!")
                breaking = 0
                continue
            }
            if (!move.matches(regex)) {
                println("You should enter numbers!")
                breaking = 0
                continue
            }
            if (move.matches(regex)) {
                if (ticTac[move[0].digitToInt() - 1][move[2].digitToInt() - 1] == '_') {
                    ticTac[move[0].digitToInt() - 1][move[2].digitToInt() - 1] = 'X'
                    breaking = 1
                } else {
                    println("This cell is occupied! Choose another one!")
                    breaking = 0
                }
            }
        } while (breaking == 0)
        cellPrint()
        if (checkWin() == 1) {
            println("X wins")
            break
        }
        if (checkWin() == 2){
            println("O wins")
            break
        }
        if ('_' !in ticTac[0] && '_' !in ticTac[1] && '_' !in ticTac[2] && checkWin() != 1 && checkWin() != 2) {
            println("Draw")
            break
        }

// тут будет функция по проверки окончания игры

// далее ход О
        do {
            move = readln()
            if (move[0].isDigit() && move[2].isDigit() && (move[0].digitToInt() == 0 || move[0].digitToInt() > 3 ||
                        move[2].digitToInt() == 0 || move[2].digitToInt() > 3)
            ) {
                println("Coordinates should be from 1 to 3!")
                breaking = 0
                continue
            }
            if (!move.matches(regex)) {
                println("You should enter numbers!")
                breaking = 0
                continue
            }
            if (move.matches(regex)) {
                if (ticTac[move[0].digitToInt() - 1][move[2].digitToInt() - 1] == '_') {
                    ticTac[move[0].digitToInt() - 1][move[2].digitToInt() - 1] = 'O'
                    breaking = 1
                } else {
                    println("This cell is occupied! Choose another one!")
                    breaking = 0
                }
            }
        } while (breaking == 0)

        cellPrint()
        if (checkWin() == 1) {
            println("X wins")
            break
        }
        if (checkWin() == 2){
            println("O wins")
            break
        }
        if ('_' !in ticTac[0] && '_' !in ticTac[1] && '_' !in ticTac[2] && checkWin() != 1 && checkWin() != 2) {
            println("Draw")
            break
        }


    } while (finish != 1)
}

fun cellPrint() {
        println("---------")
        for (j in 0..2) {
            println(ticTac[j].joinToString(prefix = "| ", separator = " ", postfix = " |"))
        }
        println("---------")
    }

fun checkWin(): Int {
    var code = 0
    if ((ticTac[0][0] == 'X' && ticTac[0][1] == 'X' && ticTac[0][2] == 'X') ||
        (ticTac[1][0] == 'X' && ticTac[1][1] == 'X' && ticTac[1][2] == 'X') ||
        (ticTac[2][0] == 'X' && ticTac[2][1] == 'X' && ticTac[2][2] == 'X') ||
        (ticTac[0][0] == 'X' && ticTac[1][0] == 'X' && ticTac[2][0] == 'X') ||
        (ticTac[0][1] == 'X' && ticTac[1][1] == 'X' && ticTac[2][1] == 'X') ||
        (ticTac[0][2] == 'X' && ticTac[1][2] == 'X' && ticTac[2][2] == 'X') ||
        (ticTac[0][0] == 'X' && ticTac[1][1] == 'X' && ticTac[2][2] == 'X') ||
        (ticTac[2][0] == 'X' && ticTac[1][1] == 'X' && ticTac[0][2] == 'X')
    ) {
        code = 1
    }
    if ((ticTac[0][0] == 'O' && ticTac[0][1] == 'O' && ticTac[0][2] == 'O') ||
        (ticTac[1][0] == 'O' && ticTac[1][1] == 'O' && ticTac[1][2] == 'O') ||
        (ticTac[2][0] == 'O' && ticTac[2][1] == 'O' && ticTac[2][2] == 'O') ||
        (ticTac[0][0] == 'O' && ticTac[1][0] == 'O' && ticTac[2][0] == 'O') ||
        (ticTac[0][1] == 'O' && ticTac[1][1] == 'O' && ticTac[2][1] == 'O') ||
        (ticTac[0][2] == 'O' && ticTac[1][2] == 'O' && ticTac[2][2] == 'O') ||
        (ticTac[0][0] == 'O' && ticTac[1][1] == 'O' && ticTac[2][2] == 'O') ||
        (ticTac[2][0] == 'O' && ticTac[1][1] == 'O' && ticTac[0][2] == 'O')
    ) {
        code = 2
    }
    return code
}