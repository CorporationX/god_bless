package school.faang.multithreading.parallelism.bjs2_72273.heros_army;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Army {
    List<Squad> squads = new ArrayList<>();

    public void add(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> squadPowersList = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> squadPowersList.add(squad.calculateSquadPower()));
            threads.add(thread);
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        log.info("squadPowersList = {}", squadPowersList);
        return squadPowersList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
