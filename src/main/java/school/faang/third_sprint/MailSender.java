package school.faang.third_sprint;

public class MailSender {

    private static final int THREADS_COUNT = 5;
    private static final int EMAILS_COUNT = 1000;

    public static void main(String[] args) {
        int batchSize;
        if (EMAILS_COUNT < THREADS_COUNT) {
            batchSize = EMAILS_COUNT;
        } else {
            batchSize = EMAILS_COUNT / THREADS_COUNT;
        }
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * batchSize;
            int endIndex = startIndex + batchSize;
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

        System.out.println("Все сообщения отправлены");
    }
}
