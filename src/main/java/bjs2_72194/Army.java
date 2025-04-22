package bjs2_72194;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> army = new ArrayList<>();

    public void addSquad(Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (Squad squad : army) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
