package school.faang.microsoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        int sizePerThread = TOTAL_MESSAGES / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * sizePerThread;
            int end = (i + 1) * sizePerThread;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Работа завершена!");
    }
}
