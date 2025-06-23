package school.faang.weasleyfamily81240;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int TIME_SLEEP_THREAD = 1500;

    @Override
    public void run() {
        try {
            Thread.sleep(TIME_SLEEP_THREAD);
            System.out.printf("выполненно действие: %s потоком: %s %n", this.chore, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("задача '%s' прервана %n", chore);
        }
    }
}
