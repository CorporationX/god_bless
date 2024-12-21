package microsoft;


public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int batchSize = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            final int start = i * batchSize;
            final int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Поток был прерван: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все письма отправлены!");
    }
}