package school.faang.BJS2_60516;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int MAILS_PER_THREAD = 200;
    private static final int MAX_THREADS = 5;

    public static void main(String[] args) {

        Thread[] threads = new Thread[MAX_THREADS];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * MAILS_PER_THREAD + 1;
            int endIndex = startIndex + MAILS_PER_THREAD - 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("{} поток был прерван!", thread.getId());
                throw new RuntimeException("Произошел сбой отправки сообщений!");
            }
        }
        log.info("Все письма отправлены!");
    }
}
