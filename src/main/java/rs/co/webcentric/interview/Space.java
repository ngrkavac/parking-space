package rs.co.webcentric.interview;

public interface Space {
    /**
     * Get space's unique ID.
     *
     * @return ID of this space.
     */
    int getID();

    /**
     * Get space's desirability. Higher is more desirable.
     *
     * @return Desirability of this space.
     */
    int getDesirability();

    /**
     * Is this space currently occupied?
     *
     * @return True if space is occupied, false otherwise.
     */
    boolean isOccupied();

    /**
     * Get car currently occupying this space.
     *
     * @return The car currently occupying this space.
     */
    Car getOccupyingCar();
}
