package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("The message #" + i + " was successfully sent by thread " + Thread.currentThread().getName());
        }
    }
}