package school.faang.sprint3.bjs_48128;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalEmails = 1000;
        int totalThreads = 5;

        Thread[] threads = new Thread[totalThreads];
        int chunkOfEmails = totalEmails / totalThreads;
        for (int i = 0; i < totalThreads; i++) {
            SenderRunnable sender = new SenderRunnable(chunkOfEmails * i, chunkOfEmails * (i + 1));
            threads[i] = new Thread(sender);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        log.info("All emails have been sent");
    }
}
