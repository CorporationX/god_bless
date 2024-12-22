package school.faang.theywherevery48758;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()
                    + " performs the task: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " completed!");
        } catch (InterruptedException e) {
            System.out.println("the task" + chore
                    + "was aborted");
        }

    }
}
