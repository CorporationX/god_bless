package school.faang.bjs2_90000;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> squadsPowers = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> squadsPowers.add(squad.calculateTotalPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return squadsPowers.stream().mapToInt(Integer::intValue).sum();

    }


}
