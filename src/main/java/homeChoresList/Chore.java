package homeChoresList;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {

    private String name;
    private static final Random RANDOM = new Random();

    @Override
    public void run() {
        System.out.printf("Thread %s start the task '%s'%n", Thread.currentThread().getName(), this.name);
        try {
            Thread.sleep(RANDOM.nextInt(1, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Thread %s completed the task '%s'%n", Thread.currentThread().getName(), this.name);

    }
}
