package faang.school.godbless.sprint3.theyWereVeryNiceButExtremelyPoor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chore implements Runnable{

    private String taskName;

    public Chore(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        try {
            String threadName = Thread.currentThread().getName();

            System.out.println("Task " + taskName + " is being done in thread " + threadName);
            Thread.sleep(2000);
            System.out.println("Task " + taskName + " is being done in thread " + threadName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
