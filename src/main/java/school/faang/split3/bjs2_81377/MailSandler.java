package school.faang.split3.bjs2_81377;

import java.util.ArrayList;
import java.util.List;

public class MailSandler {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int EMAILS_PER_THREAD_BATCH_SIZE = TOTAL_MESSAGES / THREAD_COUNT;

    public static void main(String[] args) {
        List<Thread> sendersThread = new ArrayList<>();
        for (int i = 1; i <= THREAD_COUNT; i++) {
            Thread thread = new Thread(new SandlerRunnable(i, EMAILS_PER_THREAD_BATCH_SIZE));
            sendersThread.add(thread);
            thread.start();
        }

        try {
            for (Thread thread : sendersThread) {
                thread.join();
            }
            System.out.println("Все письма отправленны");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ожидание было прервано");
        }
    }
}