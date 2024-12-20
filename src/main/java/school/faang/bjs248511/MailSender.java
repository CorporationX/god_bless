package school.faang.bjs248511;

import lombok.val;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];
        int start;
        int end;

        for (int i = 0; i < threadsCount; i++) {
            start = i * batchSize;
            end = (i + 1) * batchSize;
            val senderRunnable = new SenderRunnable(start, end);
            threads[i] = new Thread(senderRunnable);
            senderRunnable.setThreadName(threads[i].getName());
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все письма отправлены!");
    }
}
