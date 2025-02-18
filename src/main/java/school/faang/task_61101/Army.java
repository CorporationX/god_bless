package school.faang.task_61101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Army {
    private final List<Squad> squads;

    public Army(List<Squad> squads) {
        validateArmy(squads);
        this.squads = squads;
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateTotalPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }

    private void validateArmy(List<Squad> army) {
        if (army == null) {
            throw new IllegalArgumentException("Army list can't be null");
        }
        if (army.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Squad in army can't be null");
        }
    }
}
