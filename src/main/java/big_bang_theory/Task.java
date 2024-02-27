package big_bang_theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
   private final String name;
   private final String task;
    @Override
    public void run() {
        try {
            System.out.println("Start");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("ALERT_TASK_STOP");
        }
        System.out.println("Done");
    }
}
