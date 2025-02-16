package school.faang.outlook;

public class MailSender {

    private static final int THREADS_COUNT = 5;
    private static final int TOTAL_MESSAGES_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {

        int batchSize = TOTAL_MESSAGES_COUNT / THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize + 1;
            int finish = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, finish));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
