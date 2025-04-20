package school.faang.bjs2_72141;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;


public class PowerCounterThread extends Thread {
    private final Squad squad;

    public PowerCounterThread(Squad squad) {
        super(getRunnable(squad));
        this.squad = squad;
    }

    private static Runnable getRunnable(Squad squad) {
        return squad::calculateSquadPower;
    }
}
