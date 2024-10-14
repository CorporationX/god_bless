package school.faang.m1s3.bjs2_36669_mice;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Task " + chore + " started in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task " + chore + " completed");
    }
}
