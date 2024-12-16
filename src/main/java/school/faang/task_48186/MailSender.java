package school.faang.task_48186;

public class MailSender {
    public static void main(String[] args) {
        final int totalMessages = 1000;
        final int threadCount = 5;
        final int batchSize = totalMessages / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = startIndex + batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все письма отправлены!");
    }

}
