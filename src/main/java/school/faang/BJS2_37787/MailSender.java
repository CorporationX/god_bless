package school.faang.BJS2_37787;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) {
        int messages = 1000;
        int threadsCount = 5;
        int threadSize = messages / threadsCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);

        try {
            for (int i = 0; i < threadsCount; i++) {
                int startIndex = i * threadSize;
                int endIndex = (i == threadsCount - 1) ? messages : (i + 1) * threadSize;

                executor.execute(new SenderRunnable(startIndex, endIndex));
            }

            executor.shutdown();
            boolean terminated = executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            if (terminated) {
                System.out.println("Все письма отправлены");
            }

        } catch (InterruptedException e) {
            System.err.println("Произошло прерывание ожидания завершения потоков");
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("Принудительное завершение пула потоков");
                executor.shutdownNow();
            }
        }
    }
}
