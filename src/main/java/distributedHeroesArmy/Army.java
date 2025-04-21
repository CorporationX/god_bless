package distributedHeroesArmy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {
    List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> result = new ArrayList<>(Collections.nCopies(squads.size(), 0));

        for (int i = 0; i < squads.size(); i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                int power = Squad.calculateSquadPower(squads.get(index).units);
                result.set(index, power);
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
