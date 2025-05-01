package school.faang.bjs2_72985;

/**
 * Задача "Вы работаете в Microsoft!"
 */
public class MailSender {
    private static final int THREADS_COUNT = 5;
    private static final int MAILS_QUEUE = 1001;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        int batchSize = (int) Math.ceil(MAILS_QUEUE * 1.0 / THREADS_COUNT);
        int leftMails = MAILS_QUEUE;

        for (int i = 0; i < THREADS_COUNT; i++) {
            if (leftMails <= 0) {
                break;
            }
            leftMails -= batchSize;

            int startIndex = i * batchSize;
            int endIndex = Math.min(startIndex + batchSize, MAILS_QUEUE);

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            System.out.printf("Thread %s started%n", i);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.printf("Thread %s was interrupted%n", thread.getName());
                thread.interrupt();
            }
        }
    }
}
