package school.faang.bjs2_91074;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws  InterruptedException {
        int messagesPerThread = TOTAL_MESSAGES / THREAD_COUNT;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * messagesPerThread;
            int end = (i == THREAD_COUNT - 1) ? TOTAL_MESSAGES : start + messagesPerThread;
            SenderRunnable senderRunnable = new SenderRunnable(start, end);
            threads[i] = new Thread(senderRunnable, "поток отправки-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
            log.info("Поток {} отправлен", thread.getName());
        }

        System.out.println("Все письма успешно отправленны!");
    }
}
