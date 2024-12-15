package school.faang.task_47623;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import school.faang.task_47623.model.Character;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(@NonNull Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        Thread[] threads = new Thread[characters.size()];
        PowerCalculator[] powerCalculators = new PowerCalculator[characters.size()];

        for (int i = 0; i < characters.size(); i++) {
            powerCalculators[i] = new PowerCalculator(characters.get(i));
            threads[i] = new Thread(powerCalculators[i]);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        for (PowerCalculator powerCalculator : powerCalculators) {
            totalPower += powerCalculator.getPower();
        }

        return totalPower;
    }
}
