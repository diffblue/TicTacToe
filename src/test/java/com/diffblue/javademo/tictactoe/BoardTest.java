package com.diffblue.javademo.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void playerOTopRow() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0,0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0,1), Player.CROSS);
        myBoard.setCell(new Coordinate(1,0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1,1), Player.CROSS);
        myBoard.setCell(new Coordinate(2,0), Player.NOUGHT);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player O didn't win in the top row", Player.NOUGHT, result);
    }
}
