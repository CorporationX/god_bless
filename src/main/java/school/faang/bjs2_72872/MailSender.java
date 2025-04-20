package school.faang.bjs2_72872;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int TOTAL_LETTERS = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        List<Integer> letters = new ArrayList<>();
        for (int i = 1; i <= TOTAL_LETTERS; i++) {
            letters.add(i);
        }

        List<Thread> threads = new ArrayList<>();
        int batchSize = TOTAL_LETTERS / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = letters.get(i * batchSize);
            int end = letters.get((i == THREADS_COUNT - 1) ? TOTAL_LETTERS - 1 : ((i + 1) * batchSize - 1));
            System.out.println(start);
            System.out.println(end);
            threads.add(new Thread(new SenderRunnable(start, end)));
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                log.error(ex.getMessage());
            }
        });
        log.info("All letters have been sent");
    }
}
