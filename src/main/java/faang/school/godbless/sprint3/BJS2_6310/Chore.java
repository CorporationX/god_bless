package faang.school.godbless.sprint3.BJS2_6310;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("The task '" + chore + "' has started. Executed by the thread: " + threadName);
            Thread.sleep(new Random().nextInt(5000) + 1000);
            System.out.println("The task '" + chore + "' completed by a thread: " + threadName);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("The task '" + chore + "' was interrupted.");
        }
    }
}