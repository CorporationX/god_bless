package heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();
    private int totalPower = 0;

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    private synchronized void addPower(int power) {
        totalPower += power;
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                int squadPower = squad.calculateSquadPower();
                addPower(squadPower);
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower;
    }
}
