package school.faang.bjs2_91457;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> army = new ArrayList<>();

    public void addSquad(Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() {
        List<SquadThread> threads = new ArrayList<>();

        for (Squad squad : army) {
            SquadThread thread = new SquadThread(squad);
            threads.add(thread);
            thread.start();
        }

        for (SquadThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int totalPower = 0;
        for (SquadThread thread : threads) {
            totalPower += thread.getResult();
        }

        return totalPower;
    }
}
