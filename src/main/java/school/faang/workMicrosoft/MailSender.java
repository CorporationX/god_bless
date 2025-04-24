package school.faang.workMicrosoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
        int remainder = TOTAL_MESSAGES % THREADS_COUNT;

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            if (i == THREADS_COUNT - 1) {
                end += remainder;
            }
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}