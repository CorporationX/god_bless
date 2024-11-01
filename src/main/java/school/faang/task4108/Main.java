package school.faang.task4108;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

class Kingdom {
    private final String name;

    public Kingdom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(Kingdom receiver) throws Exception {
        if (new Random().nextInt(10) < 3) { // 30% шанс недоставки
            throw new Exception("Сообщение не было доставлено от " + this.name + " к " + receiver.getName());
        }
        System.out.println("Сообщение успешно отправлено от " + this.name + " к " + receiver.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingLanding = new Kingdom("King's Landing");
        Kingdom highgarden = new Kingdom("Highgarden");

        CompletableFuture<Void> raven1 = sendRaven(winterfell, kingLanding);
        CompletableFuture<Void> raven2 = sendRaven(highgarden, winterfell);
        CompletableFuture<Void> raven3 = sendRaven(kingLanding, highgarden);

        CompletableFuture.allOf(raven1, raven2, raven3).join();
    }

    public static CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.runAsync(() -> {
            try {
                sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Ошибка: " + ex.getMessage());
            } else {
                System.out.println("Сообщение успешно доставлено.");
            }
            return null;
        });
    }
}


