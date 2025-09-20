package school.faang.bjs2_91450;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private List<Squad<? extends Character>> squads = new ArrayList<>();
    @Getter private AtomicInteger totalPower = new AtomicInteger(0);

    public void addSquad(Squad<? extends Character> squad) {
        squads.add(squad);
    }

    public void calculateTotalPower() throws InterruptedException {
        Thread[] threads = new Thread[squads.size()];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> totalPower.addAndGet(squads.get(finalI).calculateSquadPower()));
            threads[i].start();
            threads[i].join();
        }
    }
}
