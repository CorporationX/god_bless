package school.faang.bjs2_91282;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Integer> resultPowerSquad = new ArrayList<>();
        List<Thread> threads  = new ArrayList<>();

        for (Squad s : squads) {
            Thread thread = new Thread(() -> resultPowerSquad.add(s.calculateSquadPower()));
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        return resultPowerSquad.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}