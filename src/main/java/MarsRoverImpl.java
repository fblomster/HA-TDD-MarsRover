public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;
    private Direction direction;

    public MarsRoverImpl(Coordinates2D startingPosition, Direction startingDirection){
        x = startingPosition.x();
        y = startingPosition.y();
        direction = startingDirection;
    }

    @Override
    public void move(String commands){
        //TODO implement
        if (commands == "f") {
            y++;
        }
        else if (commands == "b") {
            y--;
        }
        else if (commands == "l") {
            x--;
        }
        else if (commands == "r") {
            x++;
        }
    }

    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }
}
