package com.diffblue.javademo.tictactoe;

public class Coordinate {

    public int col;
    public int row;

    public Coordinate(int col, int row) {
        // Ensure that the cell being retrieved is on the board
        if (col > 2 || row > 2) {
            throw new IllegalArgumentException("Neither Column " + col +
                    " or Row " + row + " can be above 2");
        }
        this.col = col;
        this.row = row;
    }

}
