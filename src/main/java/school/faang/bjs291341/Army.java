package school.faang.bjs291341;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad> squads;
    private int totalPower;

    public Army() {
        this.squads = new ArrayList<>();
    }

    public void addSquad(Squad archers) {
        this.squads.add(archers);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(squad);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (Squad squad : squads) {
            totalPower += squad.getTotalPower();
        }

        return totalPower;
    }
}
