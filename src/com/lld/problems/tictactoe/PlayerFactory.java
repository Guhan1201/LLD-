package com.lld.problems.tictactoe;

public class PlayerFactory {
    public static Player createPlayer(char symbol) {
        return new HumanPlayer(symbol);
    }
}


