package school.faang.multithreading.parallelism.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public void send(int countMails, int batchSize) throws InterruptedException {
        if (countMails < batchSize) {
            throw new IllegalArgumentException();
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= countMails; i += batchSize) {
            Thread thread = new Thread(new SenderRunnable(i, i + batchSize - 1));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
