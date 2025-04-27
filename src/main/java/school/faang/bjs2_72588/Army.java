package school.faang.bjs2_72588;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Army {
    private List<Squad> squads = new ArrayList<>();

    public void setSquads(List<Squad> squads) {
        if (squads != null) {
            this.squads = squads;
        } else {
            this.squads = new ArrayList<>();
        }
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger totalPower = new AtomicInteger();
        
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                totalPower.addAndGet(squad.calculateSquadPower());
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("The thread was interrupted. {}.", e.getMessage());
            }
        }

        return totalPower.get();
    }
}
