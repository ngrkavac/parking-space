package rs.co.webcentric.interview;

public class SpaceImplOccupied implements Space {

    private int id;
    private int desirability;
    private Car car;

    public SpaceImplOccupied(Space space, Car car) {
        this.id = space.getID();
        this.desirability = space.getDesirability();
        this.car = car;
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
        return true;
    }

    @Override
    public Car getOccupyingCar() {
        return car;
    }
}
