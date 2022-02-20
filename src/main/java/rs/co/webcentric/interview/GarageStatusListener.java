package rs.co.webcentric.interview;

public interface GarageStatusListener {
    /**
     * Invoked when car takes parking space.
     *
     * @param car
     * @param space
     */
    public void onSpaceTaken(Car car, Space space);

    /**
     * Invoked when car leaves parking space.
     *
     * @param car
     * @param space
     */
    public void onSpaceFreed(Car car, Space space);

    /**
     * Invoked when car leaves the parking garage.
     *
     * @param car
     */
    public void onGarageExit(Car car);
}
