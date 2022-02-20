package rs.co.webcentric.interview;

public class SpaceImplFree implements Space {

    private int id;
    private int desirability;

    public SpaceImplFree(int id, int desirability) {
        this.id = id;
        this.desirability = desirability;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public int getDesirability() {
        return desirability;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public Car getOccupyingCar() {
        return null;
    }
}
