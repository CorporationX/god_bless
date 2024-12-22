package school.faang.task_48801;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int numberOfMails = 1000;
        int numberOfThread = 5;
        int mailsPerThread = numberOfMails / numberOfThread;

        Thread[] threads = new Thread[numberOfThread];

        for (int i = 0; i < numberOfThread; i++) {
            final int startIndex = i * mailsPerThread + 1;
            final int endIndex = startIndex + mailsPerThread - 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error(String.valueOf(e));
            }
        }

        log.info("All mails sent successfully");
    }
}
