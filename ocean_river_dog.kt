import kotlin.math.*

// Main function
fun main() {
    println("Welcome to Happy Hounds!")
    val input = readLine()
    if (input != null) {
        when (input) {
            "Open" -> {
                println("Opening Happy Hounds...")
                happyHounds()
            }
            "Exit" -> {
                println("Exiting Happy Hounds... Goodbye!")
            }
            else -> {
                println("Invalid input. Please try again.")
            }
        }
    }
}

// Function to open the Happy Hounds game
fun happyHounds() {
    println("Welcome to Happy Hounds! Select your game mode: \nType '1' to play versus the computer \nType '2' to play with two players \nType '3' to go back")
    val input = readLine()
    when (input) {
        "1" -> {
            startComputerGame()
        }
        "2" -> {
            startTwoPlayerGame()
        }
        "3" -> {
            println("Going back...")
            main()
        }
        else -> {
            println("Invalid input. Please try again.")
            happyHounds()
        }
    }
}

// Function to start computer game
fun startComputerGame() {
    println("You have chosen to play against the computer. Please enter the size of the board:")
    val boardSizeString = readLine()
    if (boardSizeString != null) {
        val boardSize = boardSizeString.toInt()
        println("You have chosen a board size of $boardSize")
        val board = Array(boardSize) { CharArray(boardSize) { ' ' } }
        showBoard(board)
        playComputerGame(board)
    }
}

// Function to start two player game
fun startTwoPlayerGame() {
    println("You have chosen to play with two players. Please enter the size of the board:")
    val boardSizeString = readLine()
    if (boardSizeString != null) {
        val boardSize = boardSizeString.toInt()
        println("You have chosen a board size of $boardSize")
        val board = Array(boardSize) { CharArray(boardSize) { ' ' } }
        showBoard(board)
        playTwoPlayerGame(board)
    }
}

// Function to show game board
fun showBoard(board: Array<CharArray>) {
    val n = board.size
    println("Game Board:")
    println("  " + (1..n).joinToString { it.toString() })
    for (i in 0 until n) {
        print((i + 1).toString() + " ")
        for (j in 0 until n) {
            print(board[i][j])
            print(" ")
        }
        println()
    }
}

// Function to play computer game
fun playComputerGame(board: Array<CharArray>) {
    println("Please enter your move (row, col):")
    for (i in 0 until board.size) {
        for (j in 0 until board.size) {
            if (board[i][j] == ' ') {
                val input = readLine()
                if (input != null) {
                    val coords = input.split(",").map { it.trim().toInt() }
                    if (coords.size == 2) {
                        val row = coords[0]
                        val col = coords[1]
                        if (row in 0 until board.size && col in 0 until board.size) {
                            board[row][col] = 'X'
                            showBoard(board)
                            if (checkWin('X', board)) {
                                println("You win!")
                                break
                            }
                            val computerMove = computerTurn(board)
                            board[computerMove.first][computerMove.second] = 'O'
                            showBoard(board)
                            if (checkWin('O', board)) {
                                println("Computer wins!")
                                break
                            }
                        }
                    }
                }
            }
        }
    }
}

// Function to play two player game
fun playTwoPlayerGame(board: Array<CharArray>) {
    println("Player 1, please enter your move (row, col):")
    for (i in 0 until board.size) {
        for (j in 0 until board.size) {
            if (board[i][j] == ' ') {
                val input = readLine()
                if (input != null) {
                    val coords = input.split(",").map { it.trim().toInt() }
                    if (coords.size == 2) {
                        val row = coords[0]
                        val col = coords[1]
                        if (row in 0 until board.size && col in 0 until board.size) {
                            board[row][col] = 'X'
                            showBoard(board)
                            if (checkWin('X', board)) {
                                println("Player 1 wins!")
                                break
                            }
                            println("Player 2, please enter your move (row, col):")
                            val input2 = readLine()
                            if (input2 != null) {
                                val coords2 = input2.split(",").map { it.trim().toInt() }
                                if (coords2.size == 2) {
                                    val row2 = coords2[0]
                                    val col2 = coords2[1]
                                    if (row2 in 0 until board.size && col2 in 0 until board.size) {
                                        board[row2][col2] = 'O'
                                        showBoard(board)
                                        if (checkWin('O', board)) {
                                            println("Player 2 wins!")
                                            break
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// Function to return computer's move
fun computerTurn(board: Array<CharArray>): Pair<Int, Int> {
    println("Computer turn... ")
    val n = board.size
    var move: Pair<Int, Int>
    do {
        val row = (0 until n).random()
        val col = (0 until n).random()
        move = Pair(row, col)
    } while (board[move.first][move.second] != ' ')
    return move
}

// Function to check if game is won by a player
fun checkWin(player: Char, board: Array<CharArray>): Boolean {
    val n = board.size
    for (i in 0 until n) {
        var winRow = true
        var winCol = true
        for (j in 0 until n) {
            if (board[i][j] != player) {
                winRow = false
            }
            if (board[j][i] != player) {
                winCol = false
            }
        }
        if (winRow || winCol) {
            return true
        }
    }
    var winDiag1 = true
    var winDiag2 = true
    for (i in 0 until n) {
        if (board[i][i] != player) {
            winDiag1 = false
        }
        if (board[i][n - i - 1] != player) {
            winDiag2 = false
        }
    }
    if (winDiag1 || winDiag2) {
        return true
    }
    return false
}