package rs.co.webcentric.interview;

import java.util.Random;

public class CarImpl implements Car {

    private String plateNumber;

    public CarImpl() {
        Random random = new Random();
        this.plateNumber = String.format("%04d", random.nextInt(10000));
    }

    @Override
    public String getLicencePlateNumber() {
        return plateNumber;
    }
}
