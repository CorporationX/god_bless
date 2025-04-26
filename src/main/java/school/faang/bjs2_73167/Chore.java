package school.faang.bjs2_73167;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_TIME = 1000;
    private String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Thread is starting task: %s\n", chore);
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread's work was interrupted");
        }
    }
}
