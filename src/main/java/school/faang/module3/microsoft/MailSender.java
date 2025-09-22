package school.faang.module3.microsoft;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        int batchSize = TOTAL_MESSAGES / THREAD_COUNT;
        Thread[] threads = new Thread[THREAD_COUNT];

        int startIndex = 1;
        int endIndex = batchSize;

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
            startIndex += batchSize;
            endIndex += batchSize;
        }

        try {
            for (int i = 0; i < THREAD_COUNT; i++) {
                threads[i].join();
            }

            System.out.println("Все письма доставлены");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Письма не были отправлены! %s%n", e);
        }
    }
}
