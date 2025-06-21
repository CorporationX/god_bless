package school.faang.bjs2_81346;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int messagesPerThread = TOTAL_MESSAGES / THREAD_COUNT;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * messagesPerThread + 1;
            int end = (i + 1) * messagesPerThread;

            SenderRunnable task = new SenderRunnable(start, end);
            threads[i] = new Thread(task, "Sender-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All emails have been sent successfully!");
    }
}