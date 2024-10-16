package school.faang.m1s3.bjs2_37780_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) {
        int batchSize = 200;
        List<Thread> allThreads = new ArrayList<>();

        for (int i = 0; i < 1000; i += batchSize) {
            SenderRunnable senderRunnable = new SenderRunnable(i, i + batchSize);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            allThreads.add(thread);
        }

        for (Thread thread : allThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
            }
        }

        System.out.println("All messages sent");
    }
}
