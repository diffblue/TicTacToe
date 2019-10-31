package com.diffblue.javademo.tictactoe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
public class BoardTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void playerOEmptyCell() {
        // Arrange
        Board myBoard = new Board();
        Coordinate cell = new Coordinate(0, 0);

        // Act
        myBoard.setCell(cell, Player.NOUGHT);

        // Assert
        assertEquals("Player O not put in cell", Player.NOUGHT, myBoard.getCell(cell));
    }

    @Test
    public void playerXEmptyCell() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        Coordinate cell = new Coordinate(0, 1);

        // Act
        myBoard.setCell(cell, Player.CROSS);

        // Assert
        assertEquals("Player X not put in cell", Player.CROSS, myBoard.getCell(cell));
    }

    @Test
    public void cannotPlaceMoveInUsedCell() {
        // Arrange
        Board myBoard = new Board();
        Coordinate cell = new Coordinate(0, 0);
        myBoard.setCell(cell, Player.NOUGHT);

        // Act
        exception.expect(IllegalArgumentException.class);
        myBoard.setCell(cell, Player.CROSS);
    }

    @Test
    public void playerOTwoMovesInARow() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        Coordinate cell = new Coordinate(0, 1);

        // Act
        exception.expect(IllegalArgumentException.class);
        myBoard.setCell(cell, Player.NOUGHT);
    }

    @Test
    public void cannotPlayAfterWinning() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 0), Player.NOUGHT);

        // Act
        exception.expect(IllegalArgumentException.class);
        myBoard.setCell(new Coordinate(2, 2), Player.CROSS);
    }


    @Test
    public void playerOTopRow() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 0), Player.NOUGHT);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player O didn't win in the top row", Player.NOUGHT, result);
    }

    @Test
    public void playerOMiddleRow() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 2), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 2), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 1), Player.NOUGHT);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player O didn't win in the middle row", Player.NOUGHT, result);
    }

    @Test
    public void playerOBottomRow() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 2), Player.NOUGHT);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player O didn't win in the bottom row", Player.NOUGHT, result);
    }

    @Test
    public void playerXLeftColumn() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(1, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 2), Player.CROSS);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player X didn't win in the left column", Player.CROSS, result);
    }

    @Test
    public void playerXMiddleColumn() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(2, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(0, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 2), Player.CROSS);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player X didn't win in the middle column", Player.CROSS, result);
    }

    @Test
    public void playerXRightColumn() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(1, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(0, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 2), Player.CROSS);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player X didn't win in the right column", Player.CROSS, result);
    }

    @Test
    public void playerODiagonal() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 2), Player.NOUGHT);


        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player O didn't win in the \\", Player.NOUGHT, result);
    }

    @Test
    public void playerXDiagonal() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(1, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(0, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 2), Player.CROSS);

        // Act
        Player result = myBoard.whoHasWon();

        // Assert
        assertEquals("Player X didn't win in the /", Player.CROSS, result);
    }

    @Test
    public void playerXRandomMoveFullBoard() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(0, 2), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 2), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 0), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 1), Player.NOUGHT);
        myBoard.setCell(new Coordinate(2, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 2), Player.NOUGHT);

        // Act
        exception.expect(IllegalArgumentException.class);
        myBoard.randomMove(Player.CROSS);
    }
    
    @PrepareForTest({Board.class, Math.class})
    @Test
    public void randomMoveInputNoughtOutputIndexOutOfBoundsException() {
        // Setup mocks
        mockStatic(Math.class);
        when(Math.random()).thenReturn(0.5);

        // Arrange
        Board myBoard = new Board();

        // Act
        myBoard.randomMove(Player.NOUGHT);

        // Assert
        assertEquals("Player O not in the middle cell", Player.NOUGHT, myBoard.getCell(new Coordinate(1, 1)));
    }
}