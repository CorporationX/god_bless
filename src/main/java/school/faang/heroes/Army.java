package school.faang.heroes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();
    public int totalPower;

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateSquadPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> result.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        for (Integer i : result) {
            totalPower += i;
        }
        return totalPower;
    }
}
