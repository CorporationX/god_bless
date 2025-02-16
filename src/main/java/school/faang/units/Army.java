package school.faang.units;

import school.faang.Squad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if (army == null) {
            throw new IllegalArgumentException("the army can't be null.");
        }
        for (Squad squad : army) {
            if (squad == null) {
                throw new IllegalArgumentException("The squad in army can't be null.");
            }
        }
    }
}