package school.faang.bjs2_61228;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> sumPowers = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                synchronized (sumPowers) {
                    sumPowers.add(squad.calculateSquadPower());
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return sumPowers.stream()
                .mapToInt(power -> power)
                .sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

}
