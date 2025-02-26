package school.faang.workinmicrosoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1003;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        try {
            int batchSize = TOTAL_MESSAGES / THREADS_COUNT;
            int remaining = TOTAL_MESSAGES % THREADS_COUNT;

            Thread[] threads = new Thread[THREADS_COUNT];

            int start = 0;

            for (int i = 0; i < THREADS_COUNT; i++) {
                int end = start + batchSize + (i < remaining ? 1 : 0); // Распределяем остаток по первым потокам
                threads[i] = new Thread(new SenderRunnable(start, end));
                threads[i].start();
                start = end;
            }

            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalArgumentException(e);
        }

        System.out.println("Все письма отправлены!");
    }
}