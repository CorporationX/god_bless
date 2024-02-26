package faang.school.godbless.magicheroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() {

        int totalPower = 0;
        List<TotalPowerThread> powerThreads = new ArrayList<>();

        for (Unit unit : units) {
            TotalPowerThread thread = new TotalPowerThread(unit);
            thread.start();
            powerThreads.add(thread);
        }

        for (TotalPowerThread thread : powerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += thread.getPower();
        }

        return totalPower;
    }
}
