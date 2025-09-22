package school.faang.bjs291129.senderRunnable;

import static school.faang.bjs291129.senderRunnable.Constants.BATCH_SIZE_EMAIL_FOR_SEND;
import static school.faang.bjs291129.senderRunnable.Constants.COUNT_EMAIL_FOR_SEND;
import static school.faang.bjs291129.senderRunnable.Constants.COUNT_THREADS;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[COUNT_THREADS];
        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = i * BATCH_SIZE_EMAIL_FOR_SEND;
            int endIndex = Math.min(startIndex + BATCH_SIZE_EMAIL_FOR_SEND, COUNT_EMAIL_FOR_SEND);
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        }

        System.out.println("All emails was sent!");
    }
}

