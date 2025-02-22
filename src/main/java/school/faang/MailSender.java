package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int partMails = TOTAL_MESSAGES / THREADS_COUNT;
        int remainingEmails = TOTAL_MESSAGES % THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = 0;
            int end = start + remainingEmails;
            start = i * partMails;
            end = (i + 1) * partMails;
            if (i < remainingEmails) {
                end += 1;
            }
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            start = end;
        }
        for (Thread thread : threads) {
            thread.join();
        }
        log.info("Все письма успешно отправлены.");
    }

}
