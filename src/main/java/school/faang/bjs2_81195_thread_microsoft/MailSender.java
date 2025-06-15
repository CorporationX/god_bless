package school.faang.bjs2_81195_thread_microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int BATCH_COUNT = 200;

    public static void main(String[] args) {
        int totalMails = 1000;
        int batchesCount = (int) Math.ceil((double) totalMails / BATCH_COUNT);
        List<Thread> senderThreads = new ArrayList<>();

        for (int i = 0; i < batchesCount; i++) {
            int startIndex = i * BATCH_COUNT;
            int endIndex = Math.min(startIndex + BATCH_COUNT, totalMails) - 1;
            Thread sender = new Thread(new SenderRunnable(startIndex, endIndex));
            senderThreads.add(sender);
            sender.start();
        }

        for (Thread sender : senderThreads) {
            try {
                sender.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Waiting for sender thread interrupted. Message {}", e.getMessage());
            }
        }

        log.info("All emails processed.");
    }
}
