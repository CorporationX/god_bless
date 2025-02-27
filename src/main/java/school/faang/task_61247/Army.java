package school.faang.task_61247;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Army {
    private final List<Squad<?>> squads = new ArrayList<>();

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }

    public int calculateArmyPower() throws InterruptedException {
        final List<Thread> treads = new ArrayList<>();
        final List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad<?> squad : squads) {
            final Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            treads.add(thread);
            thread.start();
        }

        for (Thread thread : treads) {
            thread.join();
        }

        return results.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
