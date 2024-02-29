package faang.school.godbless.multithreading_async.game_of_thrones;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Kingdom whiterun = new Kingdom("Вайтран");
        Kingdom riften = new Kingdom("Рифтен");

        sendRaven(whiterun, riften)
                .handle((result, error) -> {
                    if (error != null) {
                        System.out.println("Письмо не дошло");
                    }
                    return result;
                }).join();
    }

    public static CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom recipient) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (RANDOM.nextInt(10) > 6) {
                throw new RuntimeException();
            }
            sender.sendMessage(recipient);
            System.out.println("Сообщение отправлено");
        });
    }
}
