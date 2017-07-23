package rover;

public class MoveCommand implements Commands {
    @Override
    public void execute(MarsRover rover) {
        rover.move();
    }
}
