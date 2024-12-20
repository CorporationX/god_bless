package school.faang.bjs247867.servcie;

import school.faang.bjs247867.model.Character;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> characters = new ArrayList<>();

    public int calculateTotalPower() {
        final List<Thread> threads = new ArrayList<>();
        final List<PowerCalculator> tasks = new ArrayList<>();

        int totalPower = 0;
        PowerCalculator calculator;
        Thread thread;
        for (Character character : characters) {
            calculator = new PowerCalculator(character);
            tasks.add(calculator);
            thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread myThread : threads) {
            try {
                myThread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted. Exception: " + e);
            }
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
