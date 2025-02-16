package school.faang;

public class MailSender {
    private static final int MESSAGES = 11;
    private static final int THREADS = 3;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = (MESSAGES + THREADS - 1) / THREADS;
        Thread[] threads = new Thread[THREADS];
        System.out.println(batchSize);
        for (int i = 0; i < THREADS; ++i) {
            int start = i * batchSize;
            int end = Math.min((i + 1) * batchSize, MESSAGES);
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All mails have been sent.");
    }
}
