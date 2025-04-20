package school.faang.bjs272167;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Army {
    private List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> totalPower = Collections.synchronizedList(new ArrayList<>());
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> totalPower.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted");
        }

        return totalPower.stream()
                .reduce(0, Integer::sum);
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
