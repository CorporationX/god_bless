package school.faang.bjs272508;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad == null) {
            throw new IllegalArgumentException("Значение отряда null");
        }
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerCounter> counters = new ArrayList<>();
        int totalPower = 0;

        for (Squad squad : squads) {
            SquadPowerCounter counter = new SquadPowerCounter(squad);
            counters.add(counter);
            counter.start();
        }

        for (SquadPowerCounter counter : counters) {
            counter.join();
            totalPower += counter.getSquadPower();
        }
        return totalPower;
    }
}
