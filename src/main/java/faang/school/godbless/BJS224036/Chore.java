package faang.school.godbless.BJS224036;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is starting the chore: " + chore);
            Thread.sleep(2000);
            System.out.println(threadName + " has completed the chore: " + chore);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while doing the chore: " + chore);
        }
    }
}
