package WorkOrMicrosoft;

public class MailSender {
    private static final int TOTAL_MESSAGE = 1000;
    private static final int COUNT_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        int size = TOTAL_MESSAGE / COUNT_THREAD;

        Thread[] threads = new Thread[COUNT_THREAD];

        for (int i = 0; i < COUNT_THREAD; i++) {
            int start = i * size;
            int end = (i + 1) * size;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        /*
        либо можно было написать не используя new Thread, как говорилось в лекции
        int size = TOTAL_MESSAGE / COUNT_THREAD;
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

        for (int i = 0; i < COUNT_THREAD; i++) {
            int start = i * size;
            int end = (i + 1) * size;
            executor.submit(new SenderRunnable(start, end));
        }
        executor.shutdown();

         */
    }
}
