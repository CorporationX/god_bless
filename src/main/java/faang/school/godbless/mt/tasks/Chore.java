package faang.school.godbless.mt.tasks;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private final String chore;
    private final int choreTimeInSeconds;

    public Chore(String chore, int choreTimeInSeconds) {
        this.chore = chore;
        this.choreTimeInSeconds = choreTimeInSeconds;
    }

    @Override
    public void run() {
        try {
            log.info("{} start", chore);
            Thread.sleep(choreTimeInSeconds * 1000L);
            log.info("{} finished", chore);
        } catch (InterruptedException e) {
            log.warn("{} interrupted", chore);
        }
    }
}
