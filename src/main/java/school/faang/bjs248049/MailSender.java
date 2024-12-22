package school.faang.bjs248049;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MINUTES;

public class MailSender {

    private static final int THREAD_POOL = 5;
    private static final int EMAILS = 1003;

    public static void main(String[] args) {

        final long start = System.currentTimeMillis();
        int from;
        int to;
        int range = EMAILS / THREAD_POOL;
        int remainder = EMAILS % THREAD_POOL;

        ExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL);
        SenderRunnable senderRunnable;
        for (int i = 0; i < THREAD_POOL; i++) {
            from = i * range;
            to = (i + 1) * range;
            if (i == THREAD_POOL - 1) {
                to += remainder;
            }
            senderRunnable = new SenderRunnable(from, to);
            executor.execute(senderRunnable);
        }
        executor.shutdown();
        try {
            boolean result = executor.awaitTermination(5, MINUTES);
            if (!result) {
                System.out.println("Process terminated due to thread failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }

        long end = System.currentTimeMillis();
        System.out.printf("%s: ended successfully. Time elapsed: %d ms. Count of emails sent: %d%n",
                Thread.currentThread().getName(), (end - start), SenderRunnable.getEmailCount());
    }

}
