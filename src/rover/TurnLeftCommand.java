package rover;

public class TurnLeftCommand implements Commands {
    @Override
    public void execute(MarsRover rover) {
        rover.turnLeft();
    }
}
