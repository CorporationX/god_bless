package faang.school.godbless.BJS2_5966;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        int numberOfThreads = 5;

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = 200 * i;
            int endIndex = startIndex + 199;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All the emails have been sent!");
    }
}