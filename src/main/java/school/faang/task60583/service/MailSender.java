package school.faang.task60583.service;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
        Thread[] firstThread = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            firstThread[i] = new Thread(new SenderRunnable(start, end));
            firstThread[i].start();
        }
        for (Thread thread : firstThread) {
            thread.join();
        }
        System.out.println("Все отправлено.");
    }
}
