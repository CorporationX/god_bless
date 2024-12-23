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
        List<PowerThread> powerThreads = new ArrayList<>();

        for (Warrior warrior : warriors) {
            PowerThread powerThread = new PowerThread(warrior);
            powerThreads.add(powerThread);
            powerThread.start();
        }

        for (PowerThread thread : powerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка в потоке: " + thread.getName());
            }
        }

        for (PowerThread task : powerThreads) {
            totalPower += task.getPower();
        }

        return totalPower;
    }

}
