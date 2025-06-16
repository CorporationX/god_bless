package school.faang.bjs2_81127_weasley_chores;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chore implements Runnable {
    private final String choreName;

    public Chore(String choreName) {
        this.choreName = choreName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Chore thread {} interrupted and could not complete.", Thread.currentThread().getName());
        }
        log.info("Thread {} is executing job: {}", Thread.currentThread().getName(), choreName);
    }
}
