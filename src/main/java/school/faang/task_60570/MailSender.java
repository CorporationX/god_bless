package school.faang.task_60570;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int NUMBER_OF_EMAILS_IN_QUEUE = 1000;
    private static final int NUMBER_OF_THREADS = 5;
    private static final int BATCH_SIZE = NUMBER_OF_EMAILS_IN_QUEUE / NUMBER_OF_THREADS;
    private static final List<Thread> THREADS = new ArrayList<>();

    private static int startIndex = 0;
    private static int endIndex = startIndex + BATCH_SIZE;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            THREADS.add(new Thread(new SenderRunnable(startIndex, endIndex)));
            startIndex += BATCH_SIZE;
            endIndex += BATCH_SIZE;
        }

        THREADS.forEach(Thread::start);

        for (Thread thread : THREADS) {
            thread.join();
        }

        System.out.println("Все письма отправлены!");
    }
}
