package school.faang.task_48367;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 999;
        int threadsCount = 5;
        int batchSize = (int) Math.ceil((double) totalMessages / threadsCount);

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            final int start = i * batchSize;
            final int end = Math.min(totalMessages, (i + 1) * batchSize);

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All letters have been sent!");
    }
}