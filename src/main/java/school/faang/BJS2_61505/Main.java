package school.faang.BJS2_61505;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int threadsAmount = 5;
        final TelegramBot telegramBot = new TelegramBot();
        final ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);

        IntStream.range(0, 30)
                .mapToObj(i -> executorService.submit(() -> telegramBot.sendMessage("New message " + i)))
                .toList();

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("All tasks finished withing 10 second");
            } else {
                System.out.println("Not all tasks finished within 10 second");
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting for all tasks to complete was interrupted");
        }

        if (!executorService.isTerminated()) {
            System.out.println("Force quit remaining tasks");
            executorService.shutdownNow();
        }
    }
}
