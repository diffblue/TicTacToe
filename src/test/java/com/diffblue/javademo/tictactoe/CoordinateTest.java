package com.diffblue.javademo.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {

    @Test
    void invalidCellCol() {
        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate coordinate = new Coordinate(3, 2);
        });
    }

    @Test
    void invalidCellRow() {
        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate coordinate = new Coordinate(2, 3);
        });
    }

    @Test
    void validMaxCell() {
        //Act
        Coordinate coordinate = new Coordinate(2,2);

        //Assert
        assertEquals(2, coordinate.col, "Column not set to max possible value");
        assertEquals(2, coordinate.row, "Row not set to to max possible value");
    }
}
