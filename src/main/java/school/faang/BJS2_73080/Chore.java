package school.faang.BJS2_73080;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is doing " + chore);
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " finished " + chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted while doing " + chore);
        }
    }
}
