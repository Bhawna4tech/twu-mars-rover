package rover;

public class TurnRightCommand implements Commands{
    @Override
    public void execute(MarsRover rover) {
        rover.turnRight();
    }
}
