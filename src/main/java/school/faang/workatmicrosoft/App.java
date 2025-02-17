package school.faang.workatmicrosoft;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static final int EMAILS_AMOUNT_PER_THREAD = 200;
    public static final int TOTAL_EMAILS = 1000;
    public static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(
                    EMAILS_AMOUNT_PER_THREAD * i,
                    EMAILS_AMOUNT_PER_THREAD * (i + 1) - 1
            );

            Thread thread = new Thread(senderRunnable);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
