package school.faang.sendcrows;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class RavenService {

    public CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);

                if (new Random().nextBoolean()) {
                    throw new RuntimeException("Ворон не смог доставить сообщение!");
                }

                sender.sendMessage(receiver);
                System.out.println("Сообщение успешно доставлено в " + receiver.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Ошибка при доставке сообщения: " + ex.getMessage());
            }
            return null;
        });
    }
}
