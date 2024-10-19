package bjs2_35747;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TOTAL_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);

        TelegramBot telegramBot = new TelegramBot();
        List<String> messages = List.of(
                "Hello world",
                "Java is the best programming language",
                "How has your day been?",
                "My name is John",
                "Welcome to FAANG school",
                "Can't wait for the next month",
                "Super excited to start on the new project",
                "It's a web application",
                "It's name is CorporationX",
                "We will be building lots of interesting features",
                "So far so good"
        );

        messages.forEach(message -> executorService.submit(() -> {
            try {
                telegramBot.sendMessage(message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        executorService.shutdown();
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Time limit reached. Forcing shutdown");
            executorService.shutdownNow();
        }

        System.out.println("The task has been completed");
    }
}
