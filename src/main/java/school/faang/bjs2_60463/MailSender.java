package school.faang.bjs2_60463;


import java.util.concurrent.CountDownLatch;

public class MailSender {
    private static final int THREAD_COUNT = 5;
    private static final int TOTAL_EMAILS = 1000;

    public static void main(String[] args) throws InterruptedException {
        int emailsPerThread = TOTAL_EMAILS / THREAD_COUNT;

        CountDownLatch countDownLatch = new CountDownLatch(5);
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = startIndex + emailsPerThread - 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex, countDownLatch));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("The letter has been sent!");
    }
}
