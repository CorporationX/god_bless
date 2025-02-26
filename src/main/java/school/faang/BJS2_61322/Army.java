package school.faang.BJS2_61322;

import java.util.ArrayList;

public class Army {
    private ArrayList<Squad> squads = new ArrayList<>();
    private ArrayList<Integer> results = new ArrayList<>();
    private ArrayList<Thread> threads = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        squads.forEach(squad -> {
            Thread squadThread = new Thread(() -> {
                results.add(squad.calculateSquadPower());
            });

            threads.add(squadThread);

            squadThread.start();
        });

        for (Thread t : threads) {
            t.join();
        }

        return results.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
