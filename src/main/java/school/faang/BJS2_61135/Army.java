package school.faang.BJS2_61135;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Integer> sumPower = new ArrayList<>();
        int squadsTotal = squads.size();
        Thread[] threads = new Thread[squadsTotal];
        for (int i = 0; i < squadsTotal; i++) {
            Squad squad = squads.get(i);
            threads[i] = new Thread(() -> sumPower.add(squad.calculateSquadPower()));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return sumPower.stream().mapToInt(Integer::intValue).sum();
    }
}
