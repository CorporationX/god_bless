package school.faang.weworkatmicrosoft;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int BATCH_SIZE = 200;
    private static final int TOTAL_MAILS = 1000;

    @SneakyThrows
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        List<Integer> batch = new ArrayList<>();

        for (int i = 0; i < TOTAL_MAILS; i++) {
            batch.add(i);
            if ((i + 1) % BATCH_SIZE == 0) {
                Thread thread = new Thread(new SenderRunnable(i - (BATCH_SIZE - 1), i));
                threads.add(thread);
                thread.start();
                batch = new ArrayList<>();
            }
        }
        if (!batch.isEmpty()) {
            Thread thread = new Thread(new SenderRunnable(0, batch.size()));
            threads.add(thread);
            thread.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        log.info("[SUCCESSFULLY] Finished.");
    }
}
