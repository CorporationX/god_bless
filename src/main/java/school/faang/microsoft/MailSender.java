package school.faang.microsoft;

public class MailSender {

    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int batchSize = TOTAL_MESSAGES / THREAD_COUNT;
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize - 1;

            SenderRunnable task = new SenderRunnable(start, end);
            threads[i] = new Thread(task, "Sender-" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
            System.out.println("Thread " + threads[i].getName() + " finished sending mails.");
        }

        System.out.println("All mails have been sent.");
    }
}