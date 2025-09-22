package school.faang.bjs2_91105;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;

    private static Thread[] createAndStartThreads(int totalMessages, int threadCount) {
        Thread[] threads = new Thread[threadCount];
        int batchSize = totalMessages / threadCount;

        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        return threads;
    }

    public static void joinAllThreadsAndPrint(Thread[] thread) throws InterruptedException {
        for (Thread t : thread) {
            t.join();
        }
        System.out.println("All threads is done");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = createAndStartThreads(TOTAL_MESSAGES, THREAD_COUNT);
        joinAllThreadsAndPrint(threads);
    }
}