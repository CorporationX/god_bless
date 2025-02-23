package school.faang.task_60570;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int NUMBER_OF_EMAILS_IN_QUEUE = 1000;
    private static final int NUMBER_OF_THREADS = 5;
    private static final int BATCH_SIZE = NUMBER_OF_EMAILS_IN_QUEUE / NUMBER_OF_THREADS;
    private static final List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = (i + 1) * BATCH_SIZE;
            THREADS.add(new Thread(new SenderRunnable(startIndex, endIndex)));
        }

        THREADS.forEach(Thread::start);

        for (Thread thread : THREADS) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("%s: ожидание завершения прервано%n", thread.getName());
                thread.interrupt();
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены!");
    }
}
