package school.faang.bjs2_60564;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int THREADS = 5;


    public static void main(String[] args) {
        int onePortionEmails = TOTAL_EMAILS / THREADS;

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            threads.add(new Thread(new SenderRunnable(i * onePortionEmails, (i + 1) * onePortionEmails)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

        System.out.println("Все письма успешно обработаны!");
    }
}
