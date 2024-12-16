package school.faang.task_48317;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Email sent.");
        System.out.println(String.format("Start: %d, end: %d", startIndex, endIndex));
    }
}
