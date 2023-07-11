package faang.school.godbless.SendRaven;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Getter
public class Kingdom {

    private String name;

    public void sendMessage(Kingdom kingdom) throws ExecutionException, InterruptedException {
        CompletableFuture<String> message = CompletableFuture.supplyAsync(() -> {
            if (new Random().nextInt(10) > 8) {
                throw new RuntimeException("Ворон помер");
            }
            return "Сообщение доставлено из королевства " + this.getName() + " в " + kingdom.getName();
        }).handle((msg, ex) -> ex != null ? ex.getMessage() : msg);

        System.out.println(message.get());
    }
}
