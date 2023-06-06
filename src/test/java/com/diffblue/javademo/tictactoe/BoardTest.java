package com.diffblue.javademo.tictactoe;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {

    @Test
    void playerOEmptyCell() {
        // Arrange
        Board myBoard = new Board();
        Coordinate cell = new Coordinate(0, 0);

        // Act
        myBoard.setCell(cell, Player.NOUGHT);

        // Assert
        assertEquals(Player.NOUGHT, myBoard.getCell(cell), "Player O not put in cell");
    }

    @Test
    void playerXEmptyCell() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        Coordinate cell = new Coordinate(0, 1);

        // Act
        myBoard.setCell(cell, Player.CROSS);

        // Assert
        assertEquals(Player.CROSS, myBoard.getCell(cell), "Player X not put in cell");
    }

    @Test
    void cannotPlaceMoveInUsedCell() {
        // Arrange
        Board myBoard = new Board();
        Coordinate cell = new Coordinate(0, 0);
        myBoard.setCell(cell, Player.NOUGHT);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            myBoard.setCell(cell, Player.CROSS);
        });
    }

    @Test
    void playerOTwoMovesInARow() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        Coordinate cell = new Coordinate(0, 1);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            myBoard.setCell(cell, Player.NOUGHT);
        });
    }

    @Test
    void cannotPlayAfterWinning() {
        // Arrange
        Board myBoard = new Board();
        myBoard.setCell(new Coordinate(0, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(0, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(1, 0), Player.NOUGHT);
        myBoard.setCell(new Coordinate(1, 1), Player.CROSS);
        myBoard.setCell(new Coordinate(2, 0), Player.NOUGHT);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            myBoard.setCell(new Coordinate(2, 2), Player.CROSS);
        });

    }

    @Test
    void playerOTopRow() {
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
        assertEquals(Player.NOUGHT, result, "Player O didn't win in the top row");
    }

    @Test
    void playerOMiddleRow() {
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
        assertEquals(Player.NOUGHT, result, "Player O didn't win in the middle row");
    }

    @Test
    void playerOBottomRow() {
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
        assertEquals(Player.NOUGHT, result, "Player O didn't win in the bottom row");
    }

    @Test
    void playerXLeftColumn() {
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
        assertEquals(Player.CROSS, result, "Player X didn't win in the left column");
    }

    @Test
    void playerXMiddleColumn() {
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
        assertEquals(Player.CROSS, result, "Player X didn't win in the middle column");
    }

    @Test
    void playerXRightColumn() {
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
        assertEquals(Player.CROSS, result, "Player X didn't win in the right column");
    }

    @Test
    void playerODiagonal() {
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
        assertEquals(Player.NOUGHT, result, "Player O didn't win in the \\");
    }

    @Test
    void playerXDiagonal() {
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
        assertEquals(Player.CROSS, result, "Player X didn't win in the /");
    }

    @Test
    void playerXRandomMoveFullBoard() {
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
        assertThrows(IllegalArgumentException.class, () -> myBoard.randomMove(Player.CROSS));
    }

    @Test
    void randomMoveInputNoughtOutputIndexOutOfBoundsException() {
        // Setup mocks
        try (MockedStatic<RandomMove> mockedMove = Mockito.mockStatic(RandomMove.class)) {

            mockedMove.when(RandomMove::generate).thenReturn(0.5);

            // Arrange
            Board myBoard = new Board();

            // Act
            myBoard.randomMove(Player.NOUGHT);

            // Assert
            assertEquals(Player.NOUGHT, myBoard.getCell(new Coordinate(1, 1)), "Player O not in the middle cell");
        }
    }
}
