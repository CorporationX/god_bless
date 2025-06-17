package school.faang.parallelsystem;

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
        List<Thread> threadList = new ArrayList<>();
        List<Integer> powerResults = new ArrayList<>();

        for (Squad squad : squads) {
            Thread t = new Thread(() -> {
                int power = squad.calculateSquadPower();
                powerResults.add(power);
            });
            threadList.add(t);
            t.start();
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                log.error("Поток был прерван");
                Thread.currentThread().interrupt();
            }
        }

        return powerResults.stream().mapToInt(Integer::intValue).sum();
    }
}
