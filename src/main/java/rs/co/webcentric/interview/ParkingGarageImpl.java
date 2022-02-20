package rs.co.webcentric.interview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ParkingGarageImpl implements ParkingGarage {

    @Override
    public Iterable<Space> getSpaces() {
        return initSpaces(1000);
    }

    private Iterable<Space> initSpaces(int number) {
        List<Space> initSpaces = new LinkedList<>();
        for (int i = 0; i< number; i++) {
            Space spaceFree = new SpaceImplFree(i, getRandomDesirability());
            initSpaces.add(spaceFree);
        }

        return convertToIterable(initSpaces.iterator());
    }

    private int getRandomDesirability() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static <T> Iterable<T> convertToIterable(Iterator<T> iterator) {
        return () -> iterator;
    }
}
