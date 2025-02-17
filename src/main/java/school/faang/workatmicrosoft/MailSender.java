package school.faang.workatmicrosoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int TOTAL_MAILS = 1000;
    private static final int TOTAL_THREADS = 5;
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        for (int indexThread = 0; indexThread < TOTAL_THREADS; indexThread++) {
            int currentIndex = TOTAL_MAILS / TOTAL_THREADS * indexThread;
            THREADS.add(new Thread(new SenderRunnable(currentIndex, currentIndex + TOTAL_MAILS / TOTAL_THREADS)));
            THREADS.get(indexThread).start();
        }

        try {
            for (Thread thread : THREADS) {
                thread.join();
            }
        } catch (InterruptedException exception) {
            log.error("Thread interrupted. {}\n{}", exception, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
        log.info("All mails has been sent");
    }
}
