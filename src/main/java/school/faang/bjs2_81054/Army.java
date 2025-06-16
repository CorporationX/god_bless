package school.faang.bjs2_81054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread newThread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(newThread);
            newThread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
