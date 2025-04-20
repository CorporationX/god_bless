package school.faang.heroe;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Squad> squadList = new ArrayList<>();
    private static final int TOTAL_THREAD = 5;

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<Thread> threads = new ArrayList<>(TOTAL_THREAD);
        List<Integer> resultPower = new ArrayList<>();
        for (Squad squad : squadList) {
            Thread thread = new Thread(() -> resultPower.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        return resultPower.stream().mapToInt(Integer::intValue).sum();
    }
}
