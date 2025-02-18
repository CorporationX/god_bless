package school.faang.armyofheroes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        validateSquad(squad);
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Integer> results = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            thread.start();
            threads.add(thread);
            Thread.sleep(100);
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    private void validateSquad(Squad squad) {
        Objects.requireNonNull(squad, "Отряд не может быть null");
    }
}
