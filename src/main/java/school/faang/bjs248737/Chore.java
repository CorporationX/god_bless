package school.faang.bjs248737;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        if (chore == null || chore.trim().isEmpty()) {
            throw new IllegalArgumentException("Chore cannot be null, empty, or just whitespace. "
                    + "Error in Chore constructor.");
        }
        this.chore = chore;
    }

    @Override
    public synchronized void run() {
        Thread thread = Thread.currentThread();
        try {
            log.info("Task '{}' started by Thread '{}' ", chore, thread.getName());
            Thread.sleep(1000);
            log.info("Task '{}' completed by Thread '{}' ", chore, thread.getName());
        } catch (InterruptedException e) {
            log.warn("Task '{}' was interrupted ", chore);
            thread.interrupt();
        }
    }
}