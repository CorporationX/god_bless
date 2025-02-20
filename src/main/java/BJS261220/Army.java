package BJS261220;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Army {
    ArrayList<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        if (squad == null) {
            throw new NullPointerException("squad is null");
        }
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
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
        log.info("Total thread : " + threads.size());
        return results.stream().mapToInt(Integer::intValue).sum();
    }

}
