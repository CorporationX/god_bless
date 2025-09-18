package school.faang.bjs2_91304;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadPowerThread> threads = new ArrayList<>();
        for (Squad squad : squads) {
            SquadPowerThread thread = new SquadPowerThread(squad);
            thread.start();
            threads.add(thread);
        }

        int total = 0;
        for (SquadPowerThread thread : threads) {
            thread.join();
            total += thread.getResult();
        }
        return total;
    }
}
