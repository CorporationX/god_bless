package school.faang.multithreading.parallelism.bjs2_91117;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int THREADS_COUNT = 5;
    private static final int EMAILS_COUNT = 1000;
    private static final int BATCH_SIZE = EMAILS_COUNT / THREADS_COUNT;

    public static void main(String[] args) {
        log.info("Старт отправки писем");

        final List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = i == THREADS_COUNT - 1 ? EMAILS_COUNT : (1 + i) * BATCH_SIZE;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threadList.add(thread);
        }

        threadList.forEach(MailSender::threadJoin);

        log.info("Письма успешно отправлены");
    }

    private static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Поток {} был остановлен", thread.getName());
        }
    }
}