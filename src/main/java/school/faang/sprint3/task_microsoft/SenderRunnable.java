package school.faang.sprint3.task_microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("thread:" + Thread.currentThread().getName()
                    + " ." + " mail " + i + " has been successfully sent");
        }
        System.out.println("startIndex = " + startIndex + ","
                + " endIndex = " + endIndex + " have been successfully sent");
    }
}
