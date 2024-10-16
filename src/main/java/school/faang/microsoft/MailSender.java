package school.faang.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < threadsCount; i++) {
            Integer startIndex = batchSize * i;
            Integer endIndex = batchSize * (1 + i);
            threads.add(new Thread(new SenderRunnable(startIndex, endIndex)));
            threads.get(i).start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new UnsupportedOperationException("The main thread has stopped working", e);
            }
        }

        System.out.println("Все письма отправлены!");
    }
}