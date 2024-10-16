package school.faang.multithreading.parallelism.microsoft;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    @SneakyThrows
    public void send(int countMails, int batchSize) {
        if (countMails < batchSize) {
            throw new IllegalArgumentException("countMails can't be smaller than batchSize");
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

        log.info("Все письма отправлены");
    }
}
