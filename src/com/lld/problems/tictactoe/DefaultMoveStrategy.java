package com.lld.problems.tictactoe;

public class DefaultMoveStrategy implements MoveStrategy {

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        return board.getSymbol(x, y) == '\0';
    }
}