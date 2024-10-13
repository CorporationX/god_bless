package tasks.bjs2_35850;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Army {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        Map<Character, Integer> charactersPower = new HashMap<>();
        List<PowerCalculator> threads = new ArrayList<>();

        characters.forEach(character -> {
            PowerCalculator calculator = new PowerCalculator(charactersPower, character);
            threads.add(calculator);
            calculator.start();
        });

        for (Thread thread : threads) {
            thread.join();
        }

        return charactersPower.values().stream().mapToInt(Integer::intValue).sum();
    }
}
