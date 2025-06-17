package school.faang.magicheroes.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        var threads = new ArrayList<Thread>();
        var results = new ArrayList<Integer>();
        for (var squad : squads) {
            var thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (var thread : threads) {
            thread.join();
        }
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
