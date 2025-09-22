package school.faang.distributed.army.of.heroes.of.sword.and.magic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {
    private final List<Squad> allSquads = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad != null) {
            allSquads.add(squad);
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : allSquads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
