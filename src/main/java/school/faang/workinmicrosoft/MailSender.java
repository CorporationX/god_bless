package school.faang.workinmicrosoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final Integer MAILS = 1000;
    private static final Integer THREAD_COUNTER = 5;

    public static void main(String[] args) {

        int mailsToThread = MAILS / THREAD_COUNTER;
        Thread[] threads = new Thread[THREAD_COUNTER];
        for (int i = 0; i < THREAD_COUNTER; i++) {
            int start = i * mailsToThread;
            threads[i] = new Thread(new SenderRunnable(start, start + mailsToThread));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                log.info("thread finished");
            } catch (InterruptedException e) {
                log.info("Exception on thread");
            }
        }
        log.info("Main thread is finished");
    }
}

