package com.diffblue.javademo.tictactoe;

import java.util.ArrayList;

public class Board {

    private Player[][] board = new Player[3][3];

    public Player getCell(Coordinate cell) {
        return board[cell.col][cell.row];
    }

    /**
     * Choose a random free cell for my next move.
     * @param player to place in the cell.
     */
    public void randomMove(Player player) {
        // Find all the available cells
        ArrayList<Coordinate> availableCells = new ArrayList<>();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                Coordinate currentCell = new Coordinate(i, j);
                if (getCell(currentCell) == null) {
                    availableCells.add(currentCell);
                }
            }
        }
        int numOfCells = availableCells.size();

        if (numOfCells == 0) {
            throw new IllegalArgumentException("Board is full, cannot place in a move");
        }

        // Pick a random cell
        int index = (int)(RandomMove.generate() * numOfCells);

        // Put player in that cell
        setCell(availableCells.get(index), player);
    }

    /**
     * Place a move.
     * @param cell the cell to set
     * @param player making the move
     */
    public void setCell(Coordinate cell, Player player) {
        // Ensure that the cell hasn't previously been set
        if (board[cell.col][cell.row] != null) {
            throw new IllegalArgumentException("Trying to place player in a space already played");
        }
        // Ensure the game isn't over
        if (whoHasWon() != null) {
            throw new IllegalArgumentException("Trying to place player once the game has been won");
        }
        // Ensure that the correct player is being played
        if (player != nextPlayer()) {
            throw new IllegalArgumentException("Trying to place the wrong player");
        }
        board[cell.col][cell.row] = player;
    }

    private Player nextPlayer() {
        int countO = 0;
        int countX = 0;
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (board[col][row] == Player.NOUGHT) {
                    countO++;
                } else if (board[col][row] == Player.CROSS) {
                    countX++;
                }
            }
        }
        if (countO > countX) {
            return Player.CROSS;
        }
        // Noughts always play first
        return Player.NOUGHT;
    }

    public Player whoHasWon() {
        ArrayList<Coordinate[]> winningPositions = new ArrayList<>();
        // rows
        winningPositions.add(new Coordinate[] {new Coordinate(0,0), new Coordinate(1,0), new Coordinate(2,0)});
        winningPositions.add(new Coordinate[] {new Coordinate(0,1), new Coordinate(1,1), new Coordinate(2,1)});
        winningPositions.add(new Coordinate[] {new Coordinate(0,2), new Coordinate(1,2), new Coordinate(2,2)});
        // columns
        winningPositions.add(new Coordinate[] {new Coordinate(0,0), new Coordinate(0,1), new Coordinate(0,2)});
        winningPositions.add(new Coordinate[] {new Coordinate(1,0), new Coordinate(1,1), new Coordinate(1,2)});
        winningPositions.add(new Coordinate[] {new Coordinate(2,0), new Coordinate(2,1), new Coordinate(2,2)});
        // diagonals
        winningPositions.add(new Coordinate[] {new Coordinate(0,0), new Coordinate(1,1), new Coordinate(2,2)});
        winningPositions.add(new Coordinate[] {new Coordinate(2,0), new Coordinate(1,1), new Coordinate(0,2)});

        for (Coordinate[] winningPosition : winningPositions) {
            if (getCell(winningPosition[0]) == getCell(winningPosition[1])
                    && getCell(winningPosition[1]) == getCell(winningPosition[2])) {
                if (getCell(winningPosition[0]) != null) {
                    return getCell(winningPosition[0]);
                }
            }
        }
        return null;
    }

}
