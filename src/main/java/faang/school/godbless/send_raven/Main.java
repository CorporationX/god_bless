package faang.school.godbless.send_raven;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom winterfell = new Kingdom("Винтерфелл");
        Kingdom kingslanding = new Kingdom("Королевская гавань");
        sendRaven(winterfell,kingslanding).join();
    }

    public static CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom recipient) {
        CompletableFuture<Void>ravenDelivery = CompletableFuture.supplyAsync(() -> {
            double random = Math.random();
            if (random < 0.3) {
                sender.sendMessage(recipient);
                return null;
            } else if (random < 0.6) {
                throw new RuntimeException("Ворона перехватили");
            } else {
                throw new RuntimeException("Ворон не ворон");
            }
        });
        return ravenDelivery.handle((result, exception) -> {
            if (exception == null){
                System.out.println("Послание успешно доставено");
            }
            else {
                System.out.println("Ошибка: " + exception.getMessage());
            }
            return null;
        });
    }
}
