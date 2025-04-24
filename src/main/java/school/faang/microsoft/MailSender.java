package school.faang.microsoft;


public class MailSender {
    private static final int TOTAL_EMAILS = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int emailsPerThread = TOTAL_EMAILS / THREADS_COUNT;

        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * emailsPerThread;
            int end = (i + 1) * emailsPerThread;
            SenderRunnable sender = new SenderRunnable(start, end);
            threads[i] = new Thread(sender, "Поток-" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка при ожидании потока: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все письма были успешно отправлены!");
    }
}