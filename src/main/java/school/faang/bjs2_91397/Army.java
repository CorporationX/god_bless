package school.faang.bjs2_91397;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad<? extends Fighter>> squads = new ArrayList<>();

    public void addSquad(Squad<? extends Fighter> squad) {
        if (squad == null) {
            throw new IllegalArgumentException("Не может быть нулевым или незаполненным");
        }
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<SquadPowerThread> threads = new ArrayList<>();
        for (Squad<? extends Fighter> squad : squads) {
            SquadPowerThread t = new SquadPowerThread(squad);
            t.start();
            threads.add(t);
        }
        for (SquadPowerThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int total = 0;
        for (SquadPowerThread t : threads) {
            total = total + t.getResult();
        }
        return total;
    }
}
