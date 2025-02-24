package school.faang.task_BJS2_60590;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("The message N" + i + " has been sent.");
        }
    }
}
