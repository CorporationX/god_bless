package Sprint_4_1_Task4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public CompletableFuture<String> sendMessage(Kingdom kingdom) {
        return CompletableFuture.supplyAsync(() -> " Отправил сообщение в королевство " + kingdom.getName());
    }

    @SneakyThrows
    public CompletableFuture<Object> sendRaven(Kingdom kingdomOne, Kingdom kingdomTwo) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return " Из королевства "
                    + kingdomOne.getName() + "Отправилено сообщение в королевство " + kingdomTwo.getName();
        }).handle((obj, throwable) -> {
            if (throwable != null) {
                throw new IllegalStateException("Error", throwable);
            }
            return obj;
        });
    }

    @SneakyThrows
    public static void main(String[] args) {
        Kingdom kingdomOne = new Kingdom("Kingdom One");
        Kingdom kingdomTwo = new Kingdom("Kingdom Two");
        Kingdom kingdomThree = new Kingdom("Kingdom Three");
        Kingdom kingdomFour = new Kingdom("Kingdom Four");
        CompletableFuture<String> sendingMessage = kingdomOne.sendMessage(kingdomTwo);
        CompletableFuture<Object> sendingRaven = kingdomOne.sendRaven(kingdomTwo, kingdomThree);
        System.out.println(sendingMessage.get());
        System.out.println(sendingRaven.get());
    }
}
