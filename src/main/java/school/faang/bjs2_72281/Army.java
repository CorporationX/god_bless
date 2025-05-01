package school.faang.bjs2_72281;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        int squadsTotal = squads.size();

        Thread[] threads = new Thread[squadsTotal];
        int[] squadsPower = new int[squadsTotal];

        for (int i = 0; i < squadsTotal; i++) {
            int squadNumber = i;
            threads[i] = new Thread(() -> {
                squadsPower[squadNumber] = squads.get(squadNumber).calculateSquadPower();
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("Thread %s was interrupted%n", thread.getName());
                thread.interrupt();
            }
        }

        return Arrays.stream(squadsPower).sum();
    }
}
