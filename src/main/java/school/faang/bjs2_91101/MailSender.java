package school.faang.bjs2_91101;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;

@Slf4j
public class MailSender {

    private static final int NUMBER_OF_THREADS = 5;
    private static final int LETTERS = 1000;
    private static final int BATCH_SIZE = LETTERS / NUMBER_OF_THREADS;

    public static void main(String[] args) {
        log.info("Старт отправки писем");
        ArrayList<Thread> threads = new ArrayList<>(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = i  * BATCH_SIZE + 1;
            int endIndex =  (i + 1)  * BATCH_SIZE;
            Thread thread = (new Thread(new SenderRunnable(startIndex, endIndex)));
            thread.start();
            threads.add(thread);
        }
        threads.forEach(MailSender::threadJoin);
        log.info("Письма успешно отправлены!");
    }

    private static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Поток {} был прерван", thread.getName());
        }
    }
}
