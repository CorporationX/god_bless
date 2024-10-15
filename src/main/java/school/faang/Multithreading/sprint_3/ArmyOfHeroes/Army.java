package school.faang.Multithreading.sprint_3.ArmyOfHeroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> armyList = new ArrayList<>();

    public void addCharacter(Character character) {
        armyList.add(character);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        int allCharacter = armyList.size();
        Thread[] threads = new Thread[allCharacter];
        List<PowerCalculator> powerCharacters = new ArrayList<>();

        for (int i = 0; i < allCharacter; i++) {
            Character character = armyList.get(i);
            PowerCalculator calculator = new PowerCalculator(character);
            threads[i] = new Thread(calculator);
            powerCharacters.add(calculator);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (PowerCalculator powerCharacter : powerCharacters) {
            totalPower += powerCharacter.getPowerCalculate();
        }

        return totalPower;
    }
}
