package school.faang.theywherevery48758;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private static final int SLEEP_TIME_MS = 1000;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()
                    + " performs the task: " + chore);
            Thread.sleep(SLEEP_TIME_MS);
            System.out.println(chore + " completed!");
        } catch (InterruptedException e) {
            System.out.println("the task" + chore
                    + "was aborted");
        }

    }
}
