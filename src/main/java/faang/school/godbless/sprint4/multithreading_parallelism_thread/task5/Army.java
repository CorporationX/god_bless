package faang.school.godbless.sprint4.multithreading_parallelism_thread.task5;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> army;

    public Army() {
        this.army = new ArrayList<>();
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        for (Character character : army) {
            CalculationPowerThread thread = new CalculationPowerThread(character);
            Thread t = new Thread(thread);
            t.start();
            System.out.println(t.getName() + " started");
            t.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }

    public void addUnit(Character character) {
        army.add(character);
    }
}
