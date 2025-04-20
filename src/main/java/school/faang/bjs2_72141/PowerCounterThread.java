package school.faang.bjs2_72141;

import lombok.Getter;

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
            throw new RuntimeException(e);
        }
        return this;
    }

    private static Runnable getRunnable(Squad squad) {
        return squad::calculateSquadPower;
    }
}
