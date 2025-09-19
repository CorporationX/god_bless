package school.faang.bjs2_91288;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad<? extends Unit>> squads = new ArrayList<>();

    public int calculateTotalPower() {
        SquadPowerThread[] threads = new SquadPowerThread[squads.size()];
        for (int i = 0; i < squads.size(); i++) {
            threads[i] = new SquadPowerThread(squads.get(i));
            threads[i].start();
        }
        int totalPower = 0;
        try {
            for (SquadPowerThread thread : threads) {
                thread.join();
                totalPower += thread.getPower();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Army strength calculation interrupted");
        }
        return totalPower;
    }

    public void addSquad(Squad<? extends Unit> squad) {
        if (squad == null) {
            throw new IllegalArgumentException("Squad cannot be null");
        }
        squads.add(squad);
    }
}
