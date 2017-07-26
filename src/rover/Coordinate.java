package rover;

public class Coordinate {
    private final int xCoordinate;
    private final int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return xCoordinate + " " + yCoordinate;
    }

    public Coordinate add(int stepOnXAxis, int stepOnYAxis) {
        int xCoordinate = this.xCoordinate + stepOnXAxis;
        int yCoordinate = this.yCoordinate + stepOnYAxis;
        return new Coordinate(xCoordinate, yCoordinate);
    }
}
