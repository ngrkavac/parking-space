package rs.co.webcentric.interview;

public interface ParkingGarage {
    /**
     * Get available spaces in the garage.
     *
     * @return Iterable of all spaces in the garage.
     */
    Iterable<Space> getSpaces();
}
