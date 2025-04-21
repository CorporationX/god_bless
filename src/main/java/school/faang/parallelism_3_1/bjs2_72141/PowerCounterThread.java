package school.faang.parallelism_3_1.bjs2_72141;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class PowerCounterThread extends Thread {
    private final Squad squad;

    public PowerCounterThread(Squad squad) {
        super(getRunnable(squad));
        this.squad = squad;
    }

    public PowerCounterThread handleJoin() {
        try {
            this.join();
        } catch (InterruptedException e) {
            log.warn("Thread {} interrupted!", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        return this;
    }

    private static Runnable getRunnable(Squad squad) {
        return squad::calculateSquadPower;
    }
}
