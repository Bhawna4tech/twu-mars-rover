package rover.directions;

import rover.Coordinate;
import rover.MarsRover;

public enum  Direction {

    E(1,0,"N","S"),
    W(-1,0,"S","N"),
    N(0,1,"W","E"),
    S(0,-1,"E","W");

    private final int stepOnXAxis;
    private final int stepOnYAxis;
    private final String leftDirection;
    private final String rightDirection;

    Direction(int stepOnXAxis, int stepOnYAxis, String leftDirection, String RightDirection) {
        this.stepOnXAxis = stepOnXAxis;
        this.stepOnYAxis = stepOnYAxis;
        this.leftDirection = leftDirection;
        rightDirection = RightDirection;
    }

    public Coordinate moveStep(Coordinate coordinate){
        return   coordinate.add(stepOnXAxis,stepOnYAxis);
    }

    public String getLeftDirection(){
        return leftDirection;
    }

    public String getRightDirection(){
        return rightDirection;
    }
}
