package school.faang.Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadsCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads.add(new Thread(new SenderRunnable(start, end)));
            threads.get(i).start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены.");
    }
}
