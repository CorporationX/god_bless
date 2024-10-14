package armyOfHeroesSwordAndMagic;

import java.util.ArrayList;

public class Army {
    private final ArrayList<Character> army = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        Thread[] threads = new Thread[army.size()];
        PowerCalculator[] powerCalculators = new PowerCalculator[army.size()];
        int totalPower = 0;

        for (int i = 0; i < army.size(); i++) {
            PowerCalculator powerCalculator = new PowerCalculator(army.get(i));
            powerCalculators[i] = powerCalculator;
            threads[i] = new Thread(powerCalculator);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        for (PowerCalculator powerCalculator : powerCalculators) {
            totalPower += powerCalculator.getPower();
        }
        return totalPower;
    }

    public void addUnit(Character character) {
        army.add(character);
    }
}
