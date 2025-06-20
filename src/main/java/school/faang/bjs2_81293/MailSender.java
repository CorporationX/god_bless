package school.faang.bjs2_81293;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;
    private static final int THREADS_SIZE = TOTAL_MESSAGES / THREADS_COUNT;
    @SneakyThrows
    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * THREADS_SIZE;
            int end = (i + 1) * THREADS_SIZE;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (int i = 0; i < THREADS_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new InterruptedException("Меня прервали ");
            }
        }
        log.info("Все письма отправлены");
    }
}
