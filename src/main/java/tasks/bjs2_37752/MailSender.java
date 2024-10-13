package tasks.bjs2_37752;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    private static final int THREAD_AMOUNT = 5;
    private static final int MAIL_COUNT = 200;
    private static final int TIMEOUT_THREAD = 30*1000;

    public static void main(String[] args) {
        System.out.println("Выполнение с потоками созданными в цикле:");
        long startTime = System.currentTimeMillis();
        runWithThreads();
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с потоками созданными в цикле: " + (endTime - startTime) + " мс");
        System.out.println();
        System.out.println("-".repeat(20));
        System.out.println();
        System.out.println("Выполнение с ExecutorService:");
        startTime = System.currentTimeMillis();
        runWithExecutorService();
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с ExecutorService: " + (endTime - startTime) + " мс");
    }

    private static void runWithThreads() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int startIndex = MAIL_COUNT * i;
            int endIndex = startIndex + MAIL_COUNT;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join(TIMEOUT_THREAD);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван: " + thread.getId());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все письма отправлены .");
    }

    // Метод запуска с использованием ExecutorService
    private static void runWithExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        for (int i = 0; i < THREAD_AMOUNT; i++) {
            int startIndex = MAIL_COUNT * i;
            int endIndex = startIndex + MAIL_COUNT;
            executorService.submit(new SenderRunnable(startIndex, endIndex));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT_THREAD, TimeUnit.MILLISECONDS)) {
                System.out.println("Завершение ExecutorService заняло слишком много времени.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("ExecutorService был прерван.");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Все письма отправлены (ExecutorService).");
    }
}
