package rover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarsRover {
    private static final List<String> VALID_COMMANDS = Arrays.asList("L", "R", "M");
    private static Map<String, Commands> COMMANDS = new HashMap<>();
    private static final List<String> DIRECTIONS = Arrays.asList("N", "E", "S", "W");

    private static final int Y = 1;
    private static final int X = 0;

    private String direction;
    private int[] position;

    public MarsRover(int startingX, int startingY, String direction) {
        this.position = new int[]{startingX, startingY};
        this.direction = direction;
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
        switch (direction) {
            case "N":
                position[Y] += +1;
                break;
            case "S":
                position[Y] += -1;
                break;
            case "E":
                position[X] += +1;
                break;
            case "W":
                position[X] += -1;
                break;
        }
    }

    private String asString() {
        return position[X] + " " + position[Y] + " " + direction;
    }

    public void turnLeft() {
        direction = DIRECTIONS.get((DIRECTIONS.indexOf(direction) + 3) % DIRECTIONS.size());
    }

    public void turnRight() {
        direction = DIRECTIONS.get((DIRECTIONS.indexOf(direction) + 1) % DIRECTIONS.size());
    }

    private static String[] convertInputIntoCommands(String input) {
        String[] commandArray = input.split("(?!^)");

        validateCommands(input, commandArray);

        return commandArray;
    }

    private static void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (!VALID_COMMANDS.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }


}
