package rover;

import rover.directions.Direction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rover.directions.Direction.*;

public class MarsRover {
    private static final Map<String, Commands> COMMANDS = new HashMap<>();
    private static final Map<String, Direction> DIRECTIONS = new HashMap<>();

    private static final int Y = 1;
    private static final int X = 0;

    private Direction direction;
    private Coordinate coordinate;

    public MarsRover(int startingX, int startingY, String direction) {
        initializeCommands();
        initializeDirections();
        this.coordinate = new Coordinate(startingX,startingY);
        this.direction = DIRECTIONS.get(direction);
    }

    private void initializeDirections() {
        DIRECTIONS.put("E", E);
        DIRECTIONS.put("W", W);
        DIRECTIONS.put("N", N);
        DIRECTIONS.put("S", S);
    }

    private void initializeCommands() {
        COMMANDS.put("M", new MoveCommand());
        COMMANDS.put("L", new TurnLeftCommand());
        COMMANDS.put("R", new TurnRightCommand());
    }

    public String run(String input) {
        String[] commands = convertInputIntoCommands(input);
        for (String command : commands) {
            COMMANDS.get(command).execute(this);
        }
        return asString();
    }

    public void move() {
        coordinate = direction.moveStep(coordinate);
    }

    private String asString() {
        return this.coordinate.toString() + " " + direction;
    }

    public void turnLeft() {
        direction = DIRECTIONS.get(direction.getLeftDirection());
    }

    public void turnRight() {
        direction = DIRECTIONS.get(direction.getRightDirection());
    }

    private static String[] convertInputIntoCommands(String input) {
        String[] commandArray = input.split("(?!^)");

        validateCommands(input, commandArray);

        return commandArray;
    }

    private static void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (!COMMANDS.containsKey(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }
}