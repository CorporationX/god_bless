package school.faang.BJS2_60511;

public class MailSender {
    private static final int TOTAL_MESSAGES = 1000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        int sendInterval = TOTAL_MESSAGES / THREADS_COUNT;
        int start = 1;
        int end = sendInterval;
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            start = end + 1;
            end += sendInterval;
        }
        for (int i = 0; i < THREADS_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.printf("Thread %d was interrupted\n", i);
            }
        }

        System.out.print("Все письма успешно отправлены!");
    }
}
