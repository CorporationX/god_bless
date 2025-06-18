package school.faang.parallelsystem;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> threadList = new ArrayList<>();
        List<Integer> powerResults = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                int power = squad.calculateSquadPower();
                powerResults.add(power);
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Поток был прерван");
                Thread.currentThread().interrupt();
            }
        }

        return powerResults.stream().mapToInt(Integer::intValue).sum();
    }
}
