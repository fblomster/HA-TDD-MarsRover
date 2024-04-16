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
        assertEquals(new Coordinates2D(4, 4), rover.getCurrentLocation());
    }

    @Test
    public void testLongitudWraparoundEast() {
        // Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(1, 1), Direction.EAST);

        // Act
        rover.move("ffffffff");

        // Assert
        assertEquals(new Coordinates2D(1, 1), rover.getCurrentLocation());
    }

    @Test
    public void testLongitudWraparoundWest() {
        // Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(8, 1), Direction.WEST);

        // Act
        rover.move("ffffffff");

        // Assert
        assertEquals(new Coordinates2D(8, 1), rover.getCurrentLocation());
    }

    @Test
    public void testWraparoundNorth() {
        // Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(8, 1), Direction.NORTH);

        // Act
        rover.move("ffffffff");

        // Assert
        assertEquals(new Coordinates2D(4, 1), rover.getCurrentLocation());
    }

    @Test
    public void testWraparoundSouth() {
        // Arrange
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 8), Direction.SOUTH);

        // Act
        rover.move("ffffffff"); // Move northward beyond the maximum latitude

        // Assert
        assertEquals(new Coordinates2D(7, 8), rover.getCurrentLocation());
    }


}
