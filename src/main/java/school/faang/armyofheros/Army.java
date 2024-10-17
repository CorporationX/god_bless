package school.faang.armyofheros;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Character> characters = new ArrayList<>();

    public int calculateTotalPower() {
        int power = 0;

        for(Character character : characters){
            PowerCalculator calculatorThread = new PowerCalculator(character);
            calculatorThread.start();

            try {
                calculatorThread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Ошибка в работе потока: " + e.getMessage());
            }

            power += calculatorThread.getPower();
        }

        return power;
    }

    public void addCharacter(Character character){
        characters.add(character);
    }
}
