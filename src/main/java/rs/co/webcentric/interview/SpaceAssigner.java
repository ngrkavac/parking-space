package rs.co.webcentric.interview;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class SpaceAssigner implements GarageStatusListener {

    private List<Space> freeSpacesList;
    private List<Space> occupiedSpacesList;

    /**
     * Initializes the SpaceAssigner.
     * @param garage The parking garage for which you are vending spaces.
     *
     * O(n * log n) - not very fast but should only execute once
     */
    public SpaceAssigner(ParkingGarage garage) {
        freeSpacesList = sortGarageSpacesByDesirabilityList(garage);
        occupiedSpacesList = new LinkedList<>();
    }

    /**
     * Assigns a space to an incoming car and returns that space.
     *
     * @param car The incoming car that needs a space.
     * @return The space reserved for the incoming car.
     *
     * O(1)
     */
    public Space assignSpace(Car car) {
        if (getFreeSpacesList().isEmpty()) {
            return null;
        }
        Space initialSpace = getFreeSpacesList().getFirst();
        Space occupiedSpace = new SpaceImplOccupied(initialSpace, car);
        getFreeSpacesList().remove(initialSpace);
        getFreeSpacesList().addFirst(occupiedSpace);
        return occupiedSpace;
    }

    /**
     * {@inheritDoc}
     *
     * O(n) for search, O(1) for updates
     */
    public void onSpaceTaken(Car car, Space space) {
        Optional<Space> first = getFreeSpacesList().stream()
                .filter(takenSpace -> takenSpace.getOccupyingCar() != null && takenSpace.getOccupyingCar().getLicencePlateNumber()
                        .equals(car.getLicencePlateNumber()))
                .filter(takenSpace -> takenSpace.getID() == space.getID())
                .findFirst();
        first.ifPresent(takenSpace -> {
            getFreeSpacesList().remove(takenSpace);
            getOccupiedSpacesList().addFirst(takenSpace);
        });
    }

    /**
     * {@inheritDoc}
     *
     * O(n) for search, O(1) for updates
     */
    public void onSpaceFreed(Car car, Space space) {
        Optional<Space> first = getOccupiedSpacesList().stream()
                .filter(freedSpace -> freedSpace.getOccupyingCar() != null && freedSpace.getOccupyingCar().getLicencePlateNumber()
                        .equals(car.getLicencePlateNumber()))
                .filter(freedSpace -> freedSpace.getID() == space.getID())
                .findFirst();
        first.ifPresent(freedSpace -> {
            getOccupiedSpacesList().remove(freedSpace);
            getFreeSpacesList().addFirst(freedSpace);
        });
    }

    /**
     * {@inheritDoc}
     *
     * O(n) for search, O(1) for updates
     */
    public synchronized void onGarageExit(Car car) {
        Optional<Space> first = getFreeSpacesList().stream()
                .filter(space -> space.getOccupyingCar() != null && space.getOccupyingCar().getLicencePlateNumber()
                        .equals(car.getLicencePlateNumber()))
                .findFirst();
        first.ifPresent(space -> {
            Space occupiedSpace = new SpaceImplFree(space.getID(), space.getDesirability());
            getFreeSpacesList().remove(space);
            getFreeSpacesList().add(occupiedSpace);
        });
    }

    // here only for the analysis purpose: if we want to have each place ranked we could use tree set and gain some performance
    private SortedSet<Space> sortGarageSpacesByDesirability(ParkingGarage garage) {
        SortedSet<Space> sorted = new TreeSet<>(Comparator.comparingInt(Space::getDesirability));
        Iterable<Space> spaces = garage.getSpaces();
        while(spaces.iterator().hasNext()) {
            sorted.add(spaces.iterator().next());
        }
        return sorted;
    }

    private LinkedList<Space> sortGarageSpacesByDesirabilityList(ParkingGarage garage) {
        LinkedList<Space> sorted = new LinkedList<>();
        Iterable<Space> spaces = garage.getSpaces();
        while(spaces.iterator().hasNext()) {
            sorted.add(spaces.iterator().next());
        }
        sorted.sort(Comparator.comparingInt(Space::getDesirability).reversed());
        return sorted;
    }

    public synchronized LinkedList<Space> getFreeSpacesList() {
        return (LinkedList<Space>) freeSpacesList;
    }

    public synchronized LinkedList<Space> getOccupiedSpacesList() {
        return (LinkedList<Space>) occupiedSpacesList;
    }
}
