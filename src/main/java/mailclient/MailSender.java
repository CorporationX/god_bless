package mailclient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int threadsCount = 5;
        int emailsPerThread = totalEmails / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * emailsPerThread;
            int end = start + emailsPerThread;
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
