package school.faang.BJS2_72921;

public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_EMAILS / THREAD_COUNT;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * batchSize + 1;
            int endIndex = (i == THREAD_COUNT - 1) ? TOTAL_EMAILS : (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Все письма отправлены");
    }
}
