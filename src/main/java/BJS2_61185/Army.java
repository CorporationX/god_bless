package BJS2_61185;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> squadPowers = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> squadPowers.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
        }

        return squadPowers.stream().mapToInt(Integer::intValue).sum();
    }
}
