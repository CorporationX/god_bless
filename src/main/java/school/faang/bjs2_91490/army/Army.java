package school.faang.bjs2_91490.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad<?>> squads = new ArrayList<>();

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerThread> threads = new ArrayList<>();

        for (Squad<?> squad : squads) {
            SquadPowerThread thread = new SquadPowerThread(squad);
            threads.add(thread);
            thread.start();
        }

        int totalPower = 0;

        for (SquadPowerThread thread : threads) {
            thread.join();
            totalPower += thread.getSquadPower();
        }

        return totalPower;
    }
}