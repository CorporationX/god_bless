package school.faang.units;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Army {
    private final List<Squad> army;

    public Army(List<Squad> army) {
        validateArmy(army);
        this.army = army;
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : army) {
            Thread thread = new Thread(() -> result.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateArmy(List<Squad> army) {
        if (army == null || army.isEmpty()) {
            throw new IllegalArgumentException("The army can't be null or empty.");
        }
        if (army.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Squad in army can't be null.");
        }
    }
}