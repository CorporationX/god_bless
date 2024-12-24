package school.faang.sprint3.bjs248085;

import java.util.ArrayList;
import java.util.List;

class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> tasks = new ArrayList<>();

        try {
            for (Warrior warrior : warriors) {
                PowerCalculator calculator = new PowerCalculator(warrior);
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
        } catch (InterruptedException e) {
            System.err.println("Поток был прерван.");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка.");
        }

        return totalPower;
    }
}