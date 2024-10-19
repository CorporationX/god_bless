package faang.school.godbless.mt.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private final static int THREAD_COUNT = 5;

    public static void main(String[] args) {
        final int messageCount = 1000;

        new MailSender().sendMessages(messageCount);
    }

    public void sendMessages(int messageCount) {
        final int batchSize = messageCount / THREAD_COUNT;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            var start = i * batchSize;
            var end = (i + 1) * batchSize;
            var thread = new Thread(new SenderRunnable(start, end));
            threads.add(thread);
            thread.start();
        }
        handleEndSending(threads);
    }

    private void handleEndSending(List<Thread> threads) {
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
