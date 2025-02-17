package school.faang.workatmicrosoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class MailSender {
    private static final int TOTAL_MAILS = 1000;
    private static final int TOTAL_THREADS = 5;
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        try {
            for (int indexThread = 0; indexThread < TOTAL_THREADS; indexThread++) {
                int currentIndex = TOTAL_MAILS / TOTAL_THREADS * indexThread;
                THREADS.add(new Thread(new SenderRunnable(currentIndex, currentIndex + TOTAL_MAILS / TOTAL_THREADS)));
                if (THREADS.contains(THREADS.get(indexThread))) {
                    THREADS.get(indexThread).start();
                } else {
                    throw new NoSuchElementException("Thread is missing");
                }
            }
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }

        try {
            for (Thread thread : THREADS) {
                thread.join();
            }
        } catch (InterruptedException exception) {
            log.error("Thread is interrupted", exception);
        }
        log.info("All mails has been sent");
    }
}
