package faang.school.godbless.sprint3.BJS2_6306;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        int messagesPerThread = TOTAL_MESSAGES / THREADS_COUNT;
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = (i + 1) * messagesPerThread - 1;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }

        System.out.println("All messages have been sent.");
    }
}