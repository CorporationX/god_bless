package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int numberOfThreads = 5;

        int emailsPerThread = totalEmails / numberOfThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        IntStream.range(0, numberOfThreads).forEach(i -> {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = (i + 1) * emailsPerThread;

            if (i == numberOfThreads - 1) {
                endIndex = totalEmails;
            }

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            executorService.submit(senderRunnable);
        });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All emails have been sent successfully!");
    }
}