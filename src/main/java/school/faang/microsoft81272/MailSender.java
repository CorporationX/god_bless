package school.faang.microsoft81272;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;
    private static final int BATCH_SIZE = TOTAL_MESSAGES / THREADS_COUNT;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * BATCH_SIZE;
            int end = (i + 1) * BATCH_SIZE;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.printf("Все %s сообщений отправленный %n", SenderRunnable.getCount());
    }
}
