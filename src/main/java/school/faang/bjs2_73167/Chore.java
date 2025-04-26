package school.faang.bjs2_73167;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        Thread thread = new Thread(() -> System.out.printf("Doing task: %s\n", chore), chore);
        try {
            System.out.printf("Thread is starting task: %s\n", thread.getName());
            thread.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
