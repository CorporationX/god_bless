package BJS2_23677_WorkingInMicrosoft;

import java.util.concurrent.CountDownLatch;

public class MailSender {
    private static final int THREAD_COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = 200 * (i + 1);

            Thread thread = new Thread(() -> {
                new SenderRunnable(startIndex, endIndex).run();
                cdl.countDown();
            });
            thread.start();
            System.out.println("Thread " + (i + 1) + " is on the way...");
        }
        cdl.await();
        System.out.println("All messages have been sent!");
    }
}
