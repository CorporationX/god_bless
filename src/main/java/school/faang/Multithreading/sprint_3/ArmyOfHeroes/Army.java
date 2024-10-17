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
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> powerCharacters = new ArrayList<>();

        for (Character character : armyList) {
            PowerCalculator calculator = new PowerCalculator(character);
            threads.add(new Thread(calculator));
            powerCharacters.add(calculator);
        }

        for (Thread thread : threads) {
            thread.start();

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
