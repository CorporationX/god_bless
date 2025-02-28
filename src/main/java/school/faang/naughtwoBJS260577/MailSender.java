package school.faang.naughtwoBJS260577;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MailSender {
    private static final int ALL_LETTERS = 17;
    private static final int ALL_THREADS = 3;
    private static final int WAIT_TIME_MINUTES = 2;

    public static void main(String[] args) {

        int letterGroup = ALL_LETTERS / ALL_THREADS;

        ExecutorService executor = Executors.newFixedThreadPool(ALL_THREADS);

        for (int i = 0; i < ALL_THREADS; i++) {
            int startIndex = i * letterGroup + 1;
            int endIndex;
            if (i == (ALL_THREADS - 1)) {
                endIndex = ALL_LETTERS;
            } else {
                endIndex = startIndex + letterGroup;
            }
            executor.submit(new SenderRunnable(startIndex, endIndex));
        }

        executor.shutdown();
        log.info("All letters have been sent!");

        try {
            if (!executor.awaitTermination(WAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

