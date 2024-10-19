package faang.school.godbless.mt.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) {
        final int messageCount = 1000;
        final int threadsCount = 5;

        sendMessages(messageCount, threadsCount);
    }

    public static void sendMessages(int messageCount, int threadCount) {
        final int batchSize = messageCount / threadCount;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            var start = i * batchSize;
            var end = (i + 1) * batchSize;
            var thread = new Thread(new SenderRunnable(start, end));
            threads.add(thread);
            thread.start();
        }

        handleEndSending(threads);
    }

    private static void handleEndSending(List<Thread> threads) {
        try {
            for (var thread : threads) {
                thread.join();
            }
            System.out.println("Main end");
        } catch (InterruptedException e) {
            System.err.printf("Sending interrupted %s%n", e);
        }
    }
}
