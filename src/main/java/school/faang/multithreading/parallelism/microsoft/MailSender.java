package school.faang.multithreading.parallelism.microsoft;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    @SneakyThrows
    public void send(int countMails, int batchSize) {
        if (countMails < batchSize) {
            throw new IllegalArgumentException();
        }

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= countMails; i += batchSize) {
            Thread thread = new Thread(new SenderRunnable(i, i + batchSize - 1));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Все письма отправлены");
    }
}
