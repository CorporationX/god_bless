package school.faang.BJS2_73080;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int WORKING_TIME = 1000;
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is doing " + chore);
        try {
            Thread.sleep(WORKING_TIME);
            System.out.println(Thread.currentThread().getName() + " finished " + chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted while doing " + chore);
        }
    }
}
