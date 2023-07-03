package faang.school.godbless.multithreading_parallelism;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i+1) * 200 + 1;
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(sender);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All messages has been sent!");
    }
}
