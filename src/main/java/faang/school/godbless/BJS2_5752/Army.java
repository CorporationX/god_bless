package faang.school.godbless.BJS2_5752;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Creature> creaturesList = new ArrayList<>();
    private int totalPower = 0;

    public void addUnit(Creature creature) {
        creaturesList.add(creature);
    }

    public int calculateTotalPower() {
        List<PowerCalculationThread> threads = new ArrayList<>();

        for (Creature creature : creaturesList) {
            PowerCalculationThread thread = new PowerCalculationThread(creature);
            threads.add(thread);
            thread.start();
        }

        for (PowerCalculationThread thread : threads) {
            try {
                totalPower += thread.getPower();
                thread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

        return totalPower;
    }
}
