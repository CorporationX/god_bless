package bigbang;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Task implements Runnable {
    @NonNull
    private final String performerName;
    @NonNull
    private final String taskType;

    @Override
    public void run() {
        System.out.printf("%s starts doing %s%n", performerName, taskType);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.printf("%s finish his task%n", performerName);
    }
}
