package school.faang.sprint3.bjs2_61177;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {
    List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Расчет силы армии прерван", e);
            }
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }
}
