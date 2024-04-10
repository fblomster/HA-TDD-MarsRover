public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;
    private Direction direction;
    private static final int LONGITUDE_MAX = 360;
    private static final int LATITUDE_MAX = 90;

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
                y++;
                break;
            case SOUTH:
                y--;
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
                y--;
                break;
            case SOUTH:
                y++;
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
        handleWraparound();
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
        handleWraparound();
    }

    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }

    private void handleWraparound() {
        // Longitud-wraparound
        x = (x + LONGITUDE_MAX) % LONGITUDE_MAX;

        // Latitud-wraparound (vid polerna)
        if (y > LATITUDE_MAX) {
            // Placera rovern på motsatt sida av ekvatorn
            y = -LATITUDE_MAX;
            // Vänd rovern söderut om den passerade norra polen
            direction = Direction.SOUTH;
        } else if (y < -LATITUDE_MAX) {
            // Placera rovern på motsatt sida av ekvatorn
            y = LATITUDE_MAX;
            // Vänd rovern norrut om den passerade södra polen
            direction = Direction.NORTH;
        }
    }



}
