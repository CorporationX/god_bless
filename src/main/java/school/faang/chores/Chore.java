package school.faang.chores;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            System.out.println("Chore " + this.chore + " is doing by " + threadName);
            Thread.sleep(100);
            System.out.println("Thread " + threadName + " completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
