package school.faang.bjs2_81072;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> result.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return result.stream()
                .mapToInt(Integer::intValue).sum();
    }
}
