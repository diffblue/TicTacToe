package com.diffblue.javademo.tictactoe;

public enum Player {

    NOUGHT ("O"),
    CROSS ("X");

    private String symbol;

    Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
