package com.lld.problems.tictactoe;

/**
 * Represents a player in Tic-Tac-Toe game
 */
public class Player {
    private String name;
    private char symbol; // 'X' or 'O'

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}

