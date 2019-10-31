package com.diffblue.javademo.tictactoe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void invalidCellCol() {
        // Act
        exception.expect(IllegalArgumentException.class);
        Coordinate coordinate = new Coordinate(3,2);
    }

    @Test
    public void invalidCellRow() {
        // Act
        exception.expect(IllegalArgumentException.class);
        Coordinate coordinate = new Coordinate(2,3);
    }

    @Test
    public void validMaxCell() {
        //Act
        Coordinate coordinate = new Coordinate(2,2);

        //Assert
        assertEquals("Column not set to max possible value", 2, coordinate.col);
        assertEquals("Row not set to to max possible value", 2, coordinate.row);
    }
}
