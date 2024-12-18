package school.faang.bjs247867.servcie;

import school.faang.bjs247867.model.Character;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> characters = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();
        final List<PowerCalculator> tasks = new ArrayList<>();

        int totalPower = 0;
        for (Character character : characters) {
            PowerCalculator calculator = new PowerCalculator(character);
            tasks.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

    public void addUnit(Character character) {
        characters.add(character);
    }
}
