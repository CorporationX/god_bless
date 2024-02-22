package faang.school.godbless.r_edzie.parallelism.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> UNITS = new ArrayList<>();

    public void addUnit(Unit unit) {
        UNITS.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerThread> powerThreads = new ArrayList<>();

        for (Unit unit : UNITS) {
            PowerThread thread = new PowerThread(unit);
            thread.start();
            powerThreads.add(thread);
        }

        for (PowerThread powerThread : powerThreads) {
            try {
                powerThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            totalPower += powerThread.getPower();
        }

        return totalPower;
    }
}
