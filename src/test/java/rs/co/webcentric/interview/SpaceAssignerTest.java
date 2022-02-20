package rs.co.webcentric.interview;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpaceAssignerTest {

    @Test
    void testSpaceAssignment() {
        ParkingGarage parkingGarage = new ParkingGarageImpl();
        SpaceAssigner spaceAssigner = new SpaceAssigner(parkingGarage);
        Car car = new CarImpl();
        Space space = spaceAssigner.assignSpace(car);
        assertEquals(1000, spaceAssigner.getFreeSpacesList().size());
        assertEquals(0, spaceAssigner.getOccupiedSpacesList().size());

        spaceAssigner.onSpaceTaken(car, space);

        assertEquals(999, spaceAssigner.getFreeSpacesList().size());
        assertEquals(1, spaceAssigner.getOccupiedSpacesList().size());

        spaceAssigner.onSpaceFreed(car, space);

        assertEquals(1000, spaceAssigner.getFreeSpacesList().size());
        assertEquals(0, spaceAssigner.getOccupiedSpacesList().size());

        spaceAssigner.onGarageExit(car);

        assertEquals(1000, spaceAssigner.getFreeSpacesList().size());
        assertEquals(0, spaceAssigner.getOccupiedSpacesList().size());
    }

}
