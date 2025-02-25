package school.faang.workformicrosoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
        int remainingMessages = TOTAL_MESSAGES % THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = start + batchSize;

            if (i == THREADS_COUNT - 1) {
                end += remainingMessages;
            }

            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        }

        System.out.println("Все сообщения успешно отправлены!");
    }
}
