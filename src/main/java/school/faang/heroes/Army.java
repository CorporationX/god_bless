package school.faang.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Thread> threads = new ArrayList<>();
    private final List<Squad> squads = new ArrayList<>();
    private final List<Integer> squadsPower = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
        threads.add(new Thread(() -> squadsPower.add(squad.calculateTotalPower())));
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        return squadsPower.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
