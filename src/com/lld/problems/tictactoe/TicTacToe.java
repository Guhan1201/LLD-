package com.lld.problems.tictactoe;

/**
 * Main Tic-Tac-Toe Game class
 * Manages game logic, player switching, and game state
 */
public class TicTacToe {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameState gameState;

    /**
     * Initialize a new Tic-Tac-Toe game
     * @param playerXName Name of player X
     * @param playerOName Name of player O
     */
    public TicTacToe(String playerXName, String playerOName) {
        this.board = new Board();
        this.playerX = new Player(playerXName, 'X');
        this.playerO = new Player(playerOName, 'O');
        this.currentPlayer = playerX; // X starts first
        this.gameState = GameState.IN_PROGRESS;
    }

    /**
     * Make a move in the game
     * @param row Row index (0-2)
     * @param col Column index (0-2)
     * @return true if move was successful
     */
    public boolean makeMove(int row, int col) {
        // Check if game is still ongoing
        if (gameState != GameState.IN_PROGRESS) {
            System.out.println("Game is already over!");
            return false;
        }

        // Validate and place move
        if (!board.isValidMove(row, col)) {
            System.out.println("Invalid move! Cell is already occupied or out of bounds.");
            return false;
        }

        // Place the move on board
        board.placeMove(row, col, currentPlayer.getSymbol());

        // Check win condition
        if (board.checkWin(currentPlayer.getSymbol())) {
            gameState = currentPlayer == playerX ? GameState.PLAYER_X_WINS : GameState.PLAYER_O_WINS;
            return true;
        }

        // Check draw condition
        if (board.isBoardFull()) {
            gameState = GameState.DRAW;
            return true;
        }

        // Switch player
        switchPlayer();
        return true;
    }

    /**
     * Switch to the other player
     */
    private void switchPlayer() {
        currentPlayer = currentPlayer == playerX ? playerO : playerX;
    }

    /**
     * Get current game state
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * Get current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Get the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Get player X
     */
    public Player getPlayerX() {
        return playerX;
    }

    /**
     * Get player O
     */
    public Player getPlayerO() {
        return playerO;
    }

    /**
     * Check if game is over
     */
    public boolean isGameOver() {
        return gameState != GameState.IN_PROGRESS;
    }

    /**
     * Display game status
     */
    public void displayGameStatus() {
        board.displayBoard();
        System.out.println("Current Player: " + currentPlayer);
        System.out.println("Game State: " + gameState);
    }

    /**
     * Reset the game
     */
    public void resetGame() {
        board.reset();
        currentPlayer = playerX;
        gameState = GameState.IN_PROGRESS;
    }
}

