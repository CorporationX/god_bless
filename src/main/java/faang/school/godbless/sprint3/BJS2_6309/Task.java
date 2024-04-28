package faang.school.godbless.sprint3.BJS2_6309;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.println(name + " started to complete the task: " + task);

        try {
            Thread.sleep(new Random().nextInt(5000) + 1000);
            System.out.println(name + " has completed: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted during execution: " + task);
            Thread.currentThread().interrupt();
        }
    }
}