package school.faang.weasleyfamily81240;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            System.out.printf("выполненно действие: %s потоком: %s %n", this.chore, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("задача '%s' прервана %n", chore);
        }
    }
}
