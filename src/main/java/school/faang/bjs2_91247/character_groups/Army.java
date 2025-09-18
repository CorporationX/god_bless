package school.faang.bjs2_91247.character_groups;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger(0);

        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread newThread = new Thread(() -> {
                int result = squad.calculateSquadPower();
                totalPower.addAndGet(result);
            });
            threads.add(newThread);
            newThread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower.intValue();
    }

    public void addSquad(Squad squad) {
        Objects.requireNonNull(squad, "отряд не может быть null!");
        if (squad.getCharacterSquad().isEmpty()) {
            throw new IllegalArgumentException("отряд не может быть пустым!");
        }
        this.squads.add(squad);
    }
}