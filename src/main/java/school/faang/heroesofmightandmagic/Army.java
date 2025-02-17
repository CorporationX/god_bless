package school.faang.heroesofmightandmagic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Army {
    private final List<Squad> army = new ArrayList<>();
    private final List<Thread> threads = new ArrayList<>();
    private final List<Integer> sum = new CopyOnWriteArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        Objects.requireNonNull(army, "Army is null");
        army.forEach(squad -> {
            threads.add(new Thread(() -> sum.add(squad.calculateSquadPower())));
            threads.get(threads.size() - 1).start();
        });

        for (Thread thread : threads) {
            thread.join();
        }
        return sum.stream().reduce(0, Integer::sum);
    }

    public void addSquad(Squad squad) {
        Objects.requireNonNull(squad, "Squad cannot be null");
        army.add(squad);
    }
}
