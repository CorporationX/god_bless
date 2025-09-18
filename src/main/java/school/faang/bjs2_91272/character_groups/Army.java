package school.faang.bjs2_91272.character_groups;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final List<Squad> squadsArmy = new ArrayList<>();

    public void addSquad(Squad squad) {
        Objects.requireNonNull(squad, "отряд не может быть null");
        if (squad.getSquadUnits().isEmpty()) {
            throw new IllegalArgumentException("отряд не может быть пустым");
        }
        squadsArmy.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger();

        int threadPoolSize = squadsArmy.size();
        List<Thread> threads = new ArrayList<>(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            int squad = i;
            threads.add(new Thread(() -> {
                int squadPower = squadsArmy.get(squad).calculateSquadPower();
                totalPower.addAndGet(totalPower.intValue() + squadPower);
            }));
            threads.get(i).start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower.intValue();
    }
}
