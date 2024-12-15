package school.faang.workin_microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerTimes = 200;
        int amountOfThreads = totalEmails / emailsPerTimes;

        Thread[] threads = new Thread[amountOfThreads];

        for (int i = 0; i < amountOfThreads; i++) {
            int startIndex = i * emailsPerTimes;
            int endIndex = (i + 1) * emailsPerTimes;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.info("Error with thread joining: {}", e.getMessage());
            }
        }

        log.info("All emails successfully sent");
    }
}
