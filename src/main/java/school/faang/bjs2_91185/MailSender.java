package school.faang.bjs2_91185;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) {
        final int totalLetters = 1000;
        final int lettersPerThread = 200;
        final int totalThreads = (int) Math.ceil((double) totalLetters / lettersPerThread);

        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);

        for (int i = 0; i < totalThreads; i++) {
            int startIndex = i * lettersPerThread + 1;
            int endIndex = Math.min((i + 1) * lettersPerThread, totalLetters);

            executor.submit(new SenderRunnable(startIndex, endIndex));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Время ожидания вышло, не все письма отправлены!");
            } else {
                System.out.println("Все письма отправлены. Количество писем: " + totalLetters);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ожидание выполнения потоков было прервано");
        }
    }
}