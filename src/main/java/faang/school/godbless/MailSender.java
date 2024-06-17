package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int numOfThreads = 5;
        int mailsPerThread = 200;

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numOfThreads; i++) {
            int startIndex = i * mailsPerThread + 1;
            int endIndex = startIndex + mailsPerThread - 1;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All " + numOfThreads * mailsPerThread + " mails are sent.");
    }
}