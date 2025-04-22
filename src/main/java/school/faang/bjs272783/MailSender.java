package school.faang.bjs272783;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) {
        final int threadCount = 5;
        final int letters = 100000;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        for (int i = 1; i <= threadCount; i++) {
            int startIndex = i * (letters / threadCount);
            int endIndex = startIndex + (letters / threadCount);
            executor.submit(new SenderRunnable(startIndex, endIndex));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            } else {
                System.out.printf("Все %d писем отправлены", letters);
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание завершения было прервано");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}