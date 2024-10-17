package mightandmagic.army;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private final List<Ship> ships;

    public Fleet() {
        ships = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        if (ship == null) {
            throw new IllegalArgumentException("Корабль не может быть null");
        }
        ships.add(ship);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<ShipPowerCalculator> calculators = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        int threadNumber = 1;

        for (Ship ship : ships) {
            ShipPowerCalculator calculator = new ShipPowerCalculator(ship);
            calculator.setName(String.valueOf(threadNumber++));
            calculators.add(calculator);

            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalPower = 0;

        for (ShipPowerCalculator calculator : calculators) {
            totalPower += calculator.getTotalPower();
        }
        return totalPower;
    }
}
