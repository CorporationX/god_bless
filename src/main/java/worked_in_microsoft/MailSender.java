package worked_in_microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        final int totalMails = 1000;
        final int totalThreads = 5;
        final var batch = totalMails / totalThreads;
        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);
        IntStream.range(0, batch).forEach(i -> {
            int startIndex = i * (totalMails / batch);
            int endIndex = (i + 1) * (totalMails / batch);
            executor.submit(new SenderRunnable(startIndex, endIndex));
        });
        try {
            executor.shutdown();
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.err.println("Не все задачи завершились за 10 минут. Принудительное завершение...");
                executor.shutdownNow();
            }
            System.out.println("Все письма успешно отправлены!");
        } catch (InterruptedException e) {
            System.err.println("Прерывание произошло во время ожидания завершения задач: " + e.getMessage());
            executor.shutdownNow();
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Не удалось корректно завершить все задачи.");
            }
        }
    }
}
