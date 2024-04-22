package faang.school.godbless.BJS2_5752;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Creature> creatures = new ArrayList<>();
    private int totalPower = 0;

    public void addUnit(Creature creature) {
        creatures.add(creature);
    }

    public int calculateTotalPower() {
        List<PowerCalculationThread> threads = new ArrayList<>();

        for (Creature creature : creatures) {
            PowerCalculationThread thread = new PowerCalculationThread(creature);
            threads.add(thread);
            thread.start();
        }

        for (PowerCalculationThread thread : threads) {
            try {
                increaseTotalPower(thread.getPower());
                thread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

        return totalPower;
    }

    private synchronized void increaseTotalPower(int power) {
            totalPower += power;
    }
}