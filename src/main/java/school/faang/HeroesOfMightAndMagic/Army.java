package school.faang.HeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {
    private static final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad == null) {
            throw new IllegalArgumentException("Squad cannot be null");
        }
        squads.add(squad);
    }

    public static int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}

