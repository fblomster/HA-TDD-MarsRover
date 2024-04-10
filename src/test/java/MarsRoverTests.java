import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTests {

    @Test
    public void testMoveForwardWest() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        //Act
        rover.move("f");

        //Assert
        assertEquals(new Coordinates2D(2, 3), rover.getCurrentLocation());
    }

    @Test
    public void testMoveBackwardEast() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.EAST);

        //Act
        rover.move("b");

        //Assert
        assertEquals(new Coordinates2D(2, 3), rover.getCurrentLocation());
    }

    @Test
    public void testMoveLeftNorth() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        //Act
        rover.move("l");

        //Assert
        assertEquals(new Coordinates2D(3, 3), rover.getCurrentLocation());
    }

    @Test
    public void testMoveRightSouth() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        //Act
        rover.move("r");

        //Assert
        assertEquals(new Coordinates2D(3, 3), rover.getCurrentLocation());
    }

    @Test
    public void testMoveWithMultipleCommands() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        //Act
        rover.move("ffrblb");

        //Assert
        assertEquals(new Coordinates2D(4, 2), rover.getCurrentLocation());
    }

    @Test
    public void testLongitudWraparound() {
        // Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(355, 0), Direction.EAST);

        // Act
        rover.move("ffffffff"); // Rör sig österut och går över gränsen för longitud

        // Assert
        assertEquals(new Coordinates2D(3, 0), rover.getCurrentLocation());
    }

    @Test
    public void testLatitudeWraparound() {
        // Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 85), Direction.NORTH);

        // Act
        rover.move("ffffffff"); // Rör sig norrut och går över gränsen för latitud

        // Assert
        assertEquals(new Coordinates2D(0, -90), rover.getCurrentLocation());
    }


}
