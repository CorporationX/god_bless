package faang.school.godbless.SendCrow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public CompletableFuture<Void> sendMessage(Kingdom kingdom, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (new Random().nextBoolean()) {
                try {
                    Thread.sleep(3000);
                    System.out.println(getName() + " доставило сообщение в королевство " + kingdom.getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("ворон не долетел(");
                throw new RuntimeException();
            }
        }, executorService);
    }
}
