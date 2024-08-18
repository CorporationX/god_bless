package faang.school.godbless.thirdsprint.mailservice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Message " + (i + 1) + " sent successfully by " + Thread.currentThread().getName());
        }
    }
}
