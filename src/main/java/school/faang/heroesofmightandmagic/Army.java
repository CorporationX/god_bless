package school.faang.heroesofmightandmagic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Army {
    private final List<Squad> army = new ArrayList<>();
    private final List<Thread> threads = new ArrayList<>();
    private final List<Integer> sum = new CopyOnWriteArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        army.forEach(squad -> {
            threads.add(new Thread(() -> sum.add(squad.calculateSquadPower())));
            if (threads.contains(threads.get(threads.size() - 1))) {
                threads.get(threads.size() - 1).start();
            } else {
                throw new NoSuchElementException("Thread not found");
            }
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
