package school.faang.task_48137;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(200 * (i - 1), i * 200 - 1);
            Thread thread = new Thread(senderRunnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Done");
    }
}
