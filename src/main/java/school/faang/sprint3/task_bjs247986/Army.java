package school.faang.sprint3.task_bjs247986;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<PowerThread> tasks = new ArrayList<>();

        for (Warrior warrior : warriors) {
            PowerThread powerThread = new PowerThread(warrior);
            tasks.add(powerThread);
            Thread thread = new Thread(powerThread);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка в потоке: " + thread.getName());
            }
        }

        for (PowerThread task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

}
