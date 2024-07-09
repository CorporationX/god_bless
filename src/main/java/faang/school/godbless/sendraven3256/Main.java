package faang.school.godbless.sendraven3256;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    static final Random RANDOM = new Random();

    public static void main(String[] args) {
        sendRaven(Kingdom.ARRYN, Kingdom.NORTH)
                .handle((message, exception) -> {
                    if (exception != null) {
                        return exception.getMessage();
                    }
                    System.out.println(message);
                    return message;
                });
        sendRaven(Kingdom.STORMLANDS, Kingdom.WESTERLANDS)
                .handle((message, exception) -> {
                    if (exception != null) {
                        return exception.getMessage();
                    }
                    System.out.println(message);
                    return message;
                });
        EXECUTOR.shutdown();
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom recipient) {
        if (RANDOM.nextInt(100) >= 80) {
            throw new RuntimeException("Raven was killed");
        }
        return CompletableFuture.supplyAsync(() -> {
            sender.sendMessage(recipient, EXECUTOR);
            return "Message was delivered";
        });
    }

}
