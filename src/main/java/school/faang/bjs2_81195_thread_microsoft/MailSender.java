package school.faang.bjs2_81195_thread_microsoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    private static final int BATCH_COUNT = 200;
    private static final int TOTAL_MAILS = 1000;

    public static void main(String[] args) {
        List<Thread> senderThreads = generateBatchedSenderThreads();
        senderThreads.forEach(Thread::start);

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

    private static List<Thread> generateBatchedSenderThreads() {
        List<Thread> senderThreads = new ArrayList<>();
        int batchesCount = (int) Math.ceil((double) TOTAL_MAILS / BATCH_COUNT);

        for (int i = 0; i < batchesCount; i++) {
            int startIndex = i * BATCH_COUNT;
            int endIndex = Math.min(startIndex + BATCH_COUNT, TOTAL_MAILS) - 1;
            Thread sender = new Thread(new SenderRunnable(startIndex, endIndex));
            senderThreads.add(sender);
        }

        return senderThreads;
    }
}
