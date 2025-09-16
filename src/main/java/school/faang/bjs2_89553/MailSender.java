package school.faang.bjs2_89553;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSender {

    private static final int EMAIL_COUNT = 1000;
    private static final int EMAIL_COUNT_THREAD = 200;
    private static final int AWAIT_TIME = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(EMAIL_COUNT / EMAIL_COUNT_THREAD);

        for (int i = 1; i <= EMAIL_COUNT; i++) {
            SenderRunnable task = new SenderRunnable(i, 200);
            executor.execute(task);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершились вовремя, закрытие пула потоков");
                executor.shutdownNow();
            } else {
                log.info("Все письмо успешно отправлены.");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
