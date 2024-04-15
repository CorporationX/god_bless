package homeChoresList;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {

    private String name;

    @Override
    public void run() {
        System.out.println(String.format("Thread %s completes the task '%s'", Thread.currentThread().getName(), this.name));
        try {
            Thread.sleep(new Random().nextInt(1, 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("Thread %s completed the task '%s'", Thread.currentThread().getName(), this.name));

    }
}
