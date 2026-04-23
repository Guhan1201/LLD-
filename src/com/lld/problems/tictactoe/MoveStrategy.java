package com.lld.problems.tictactoe;

public interface MoveStrategy {
    boolean isValidMove(int x, int y, Board board);
}
