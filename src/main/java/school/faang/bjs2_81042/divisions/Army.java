package school.faang.bjs2_81042.divisions;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> squadPowers = new ArrayList<>();

        for (Squad squad : squads) {
            Thread squadThread = new Thread(() -> squadPowers.add(squad.calculateSquadPower()));
            threads.add(squadThread);
            squadThread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return squadPowers.stream().mapToInt(Integer::intValue).sum();
    }
}
