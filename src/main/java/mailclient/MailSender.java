package mailclient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    private static final int TOTAL_EMAILS = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        sendEmails(TOTAL_EMAILS, THREADS_COUNT);
    }

    public static void sendEmails(int totalEmails, int threadsCount) {
        if (threadsCount <= 0) {
            throw new IllegalArgumentException("threadsCount must be greater than 0");
        }

        int emailsPerThread = totalEmails / threadsCount;
        int remainder = totalEmails % threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int extra = i < remainder ? 1 : 0;
            int start = i * emailsPerThread + Math.min(i, remainder);
            int emailsForThisThread = emailsPerThread + extra;
            int end = start + emailsForThisThread;

            SenderRunnable senderRunnable = new SenderRunnable(start, end);
            threads[i] = new Thread(senderRunnable, "SenderThread-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }

        log.info("All emails have been sent successfully!");
    }
}
