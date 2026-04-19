package com.lld.problems.tictactoe;

/**
 * Represents the Tic-Tac-Toe board
 * 3x3 grid where moves can be placed
 */
public class Board {
    private static final int BOARD_SIZE = 3;
    private char[][] grid;

    public Board() {
        initializeBoard();
    }

    /**
     * Initialize board with empty cells
     */
    private void initializeBoard() {
        grid = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    /**
     * Check if a move is valid (cell is empty and within bounds)
     * @param row Row index (0-2)
     * @param col Column index (0-2)
     * @return true if move is valid
     */
    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return false;
        }
        return grid[row][col] == ' ';
    }

    /**
     * Place a move on the board
     * @param row Row index
     * @param col Column index
     * @param symbol Player's symbol ('X' or 'O')
     * @return true if move was placed successfully
     */
    public boolean placeMove(int row, int col, char symbol) {
        if (!isValidMove(row, col)) {
            return false;
        }
        grid[row][col] = symbol;
        return true;
    }

    /**
     * Check if board is full (draw condition)
     * @return true if board is full
     */
    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if there's a winner
     * @param symbol Player's symbol to check
     * @return true if player with given symbol has won
     */
    public boolean checkWin(char symbol) {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (checkRow(i, symbol)) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (checkColumn(j, symbol)) {
                return true;
            }
        }

        // Check diagonals
        if (checkDiagonal(symbol) || checkAntiDiagonal(symbol)) {
            return true;
        }

        return false;
    }

    /**
     * Check if a specific row has winning condition
     */
    private boolean checkRow(int row, char symbol) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (grid[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a specific column has winning condition
     */
    private boolean checkColumn(int col, char symbol) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (grid[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if main diagonal has winning condition
     */
    private boolean checkDiagonal(char symbol) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (grid[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if anti-diagonal has winning condition
     */
    private boolean checkAntiDiagonal(char symbol) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (grid[i][BOARD_SIZE - 1 - i] != symbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Display the board in a formatted way
     */
    public void displayBoard() {
        System.out.println("\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < BOARD_SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < BOARD_SIZE - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    /**
     * Get the current state of a cell
     */
    public char getCellState(int row, int col) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return ' ';
        }
        return grid[row][col];
    }

    /**
     * Reset the board for a new game
     */
    public void reset() {
        initializeBoard();
    }
}

