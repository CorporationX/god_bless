package school.faang.bjs2_91093;

public class MailSender {
    private static final int EMAILS_COUNT = 1_000;
    private static final int THREADS_COUNT = 5;
    private static final int BATCH_SIZE = EMAILS_COUNT / THREADS_COUNT;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * BATCH_SIZE + 1;
            int endIndex = (i == THREADS_COUNT - 1) ? EMAILS_COUNT : (i + 1) * BATCH_SIZE;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                Thread.sleep(100);
                System.out.printf("Поток %s успено выполнен%n", thread.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Все потоки успешно обработаны и отправили свои письма");
    }
}