package school.faang.heroesarmy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower(List<Squad> squads) {
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());
        // без syncronizedList итог всегда выходил разный, то 55, то 90
        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("The running was interrupted: {}", thread.getName(), e);
            }
        }
        return results.stream().reduce(0, Integer::sum);
    }
}
