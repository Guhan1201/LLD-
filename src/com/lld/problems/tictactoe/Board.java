package com.lld.problems.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    char[][] board;
    private List<Player> observer;

    public Board(int size) {
        board = new char[size][size];
        observer = new ArrayList<>();
    }

    public void addObserver(Player player) {
        observer.add(player);
    }

    public void notifyObservers() {
        for (Player player : observer) {
            player.update(this);
        }
    }

    public void updateBoard(int x, int y, char symbol) {
        board[x][y] = symbol;
        notifyObservers();
    }

    public char getSymbol(int x, int y) {
        return board[x][y];
    }

    public int getSize() {
        return board.length;
    }
}