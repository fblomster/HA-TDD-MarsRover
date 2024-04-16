public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;
    private Direction direction;
    private static final int LATITUDE_MIN = 1;
    private static final int LATITUDE_MAX = 8;
    private static final int LONGITUDE_MIN = 1;
    private static final int LONGITUDE_MAX = 8;

    public MarsRoverImpl(Coordinates2D startingPosition, Direction startingDirection){
        x = startingPosition.x();
        y = startingPosition.y();
        direction = startingDirection;
    }

    @Override
    public void move(String commands){
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            switch (command) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'l':
                    turnLeft();
                    break;
                default:
                    break;
            }
        }
    }

    private void moveForward() {
        switch (direction) {
            case NORTH:
                y--;
                break;
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }
        handleWraparound();
    }

    private void moveBackward() {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x--;
                break;
            case WEST:
                x++;
                break;
        }
        handleWraparound();
    }

    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }

    private void handleWraparound() {

        // Latitud-wraparound (vid polerna)
        if (y > LATITUDE_MAX) {
            y = LATITUDE_MIN;
            if (x >= 1 && x <= 4) {
                x += 4;
            } else if (x >= 5 && x <= 8) {
                x -= 4;
            }

            // Vänd rovern söderut om den passerade norra polen
            direction = Direction.SOUTH;
        } else if (y < LATITUDE_MIN) {
            y = LATITUDE_MAX;
            if (x >= 1 && x <= 4) {
                x += 4;
            } else if (x >= 5 && x <= 8) {
                x -= 4;
            }
            // Vänd rovern norrut om den passerade södra polen
            direction = Direction.NORTH;
        }
        else {
            // Longitud-wraparound
        if (x > LONGITUDE_MAX) {
            x = LONGITUDE_MIN;
        } else if (x < LONGITUDE_MIN) {
            x = LONGITUDE_MAX;
        }
        }
    }

}
