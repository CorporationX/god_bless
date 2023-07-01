package faang.school.godbless.sprint4.multithreading_parallelism_thread.task5;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> army;

    public Army() {
        this.army = new ArrayList<>();
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<CalculationPowerThread> calculationPowerThreads = new ArrayList<>();
        for (Character character : army) {
            CalculationPowerThread calculationPowerThread = new CalculationPowerThread(character);
            calculationPowerThreads.add(calculationPowerThread);
            Thread t = new Thread(calculationPowerThread);
            threads.add(t);
            t.start();
            System.out.println(t.getName() + " started");
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return calculationPowerThreads.stream()
                .mapToInt(CalculationPowerThread::getPower)
                .sum();
    }

    public void addUnit(Character character) {
        army.add(character);
    }
}
