package school.faang.bjs2_35926.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import school.faang.bjs2_35926.model.Fighter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Army {
    private final List<Fighter> fighters = new ArrayList<>();

    public int calculateTotalPower() {
        AtomicInteger sumPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        for (Fighter fighter : fighters) {
            Thread thread = new Thread(() -> sumPower.addAndGet(fighter.getPower()));
            threads.add(thread);
        }
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return sumPower.get();
    }

    public void addUnit(@NonNull Fighter fighter) {
        fighters.add(fighter);
    }
}
