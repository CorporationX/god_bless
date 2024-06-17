package faang.school.godbless.parallelism.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    private static final int MESSAGES_NUMBER = 1_000;
    private static final int THREADS_NUMBER = 5;
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        int batchSize = MESSAGES_NUMBER / THREADS_NUMBER;
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(new SenderRunnable(i * batchSize, i * batchSize + batchSize));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Done");
    }
}
