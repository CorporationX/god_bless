package faang.school.godbless.uizliy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    private final long THREAD_SLEEP = 5000L;

    @Override
    public void run() {
        System.out.println("Starting chore " + chore + " in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            System.out.println("Thread " + chore + " with name " + Thread.currentThread().getName() + " was interrupted");
        }
        System.out.println("Finishing chore " + chore);
    }
}
