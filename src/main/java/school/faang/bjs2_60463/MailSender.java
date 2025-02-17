package school.faang.bjs2_60463;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);

        int totalEmails = 1000;
        int emailsPerThread = totalEmails / 5;

        for (int i = 0; i < 5; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = startIndex + emailsPerThread - 1;
            executor.execute(new SenderRunnable(startIndex, endIndex, countDownLatch));
        }

        countDownLatch.await();
        executor.shutdown();
        System.out.println("The letter has been sent!");
    }
}
