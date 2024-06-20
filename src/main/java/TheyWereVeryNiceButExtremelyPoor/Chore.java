package TheyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String taskName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + getTaskName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
