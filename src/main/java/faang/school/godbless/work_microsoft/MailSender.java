package faang.school.godbless.work_microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        int messageCount = 1000;
        int threadCount = 5;
        int batchSize = messageCount / threadCount;
        int bathStart = 1;
        List<Thread> threads = new ArrayList<>();

        while (messageCount > 0) {
            Thread thread = new Thread(new SenderRunnable(bathStart, bathStart + batchSize));
            threads.add(thread);
            bathStart += batchSize;
            messageCount -= batchSize;
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        System.out.println("\nВсе сообщения отправлены!");
    }
}
