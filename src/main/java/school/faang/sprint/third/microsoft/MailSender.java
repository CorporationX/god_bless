package school.faang.sprint.third.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int TOTAL_EMAILS = 100;
    private static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            int beginIndex = TOTAL_EMAILS / THREADS_AMOUNT * i + 1;
            int endIndex = beginIndex + TOTAL_EMAILS / THREADS_AMOUNT - 1;
            Thread thread = new Thread(new SenderRunnable(beginIndex, endIndex));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All messages delivered");
    }
}
