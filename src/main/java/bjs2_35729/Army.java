package bjs2_35729;

import lombok.Getter;

import java.util.List;

public class Army {
    private List<Character> army;
    @Getter
    private int totalPower;

    public void calculateTotalPower() throws InterruptedException {
        int totalThreads = 5;
        int batchSize = army.size() / totalThreads;
        PowerCalculator[] powerCalculators = new PowerCalculator[totalThreads];

        for (int i = 0; i < totalThreads - 1; i++ ) {
            List<Character> armyPortion = army.subList(batchSize * i, batchSize * i + batchSize);
            powerCalculators[i] = new PowerCalculator(armyPortion);
            powerCalculators[i].start();
        }

        List<Character> armyPortion = army.subList(batchSize * (totalThreads - 1), army.size());
        powerCalculators[totalThreads - 1] = new PowerCalculator(armyPortion);
        powerCalculators[totalThreads - 1].start();

        for (PowerCalculator powerCalculator : powerCalculators) {
            powerCalculator.join();
            totalPower += powerCalculator.getTotalPower();
        }
    }

    public Army(List<Character> army) {
        this.army = army;
    }
}
