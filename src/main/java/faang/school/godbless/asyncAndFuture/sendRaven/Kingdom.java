package faang.school.godbless.asyncAndFuture.sendRaven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@AllArgsConstructor
public class Kingdom {
    private final Random random = new Random();

    private String name;

    public CompletableFuture<String> sendMessage(Kingdom kingdom) {

        return CompletableFuture.supplyAsync(() -> sendRaven(this, kingdom))
                .handle((result, exception) -> {
                    if (exception != null) {
                        return "Возникла ошибка: " + exception.getMessage();
                    }
                    return result;
                });
    }

    private String sendRaven(Kingdom kingdom1, Kingdom kingdom2) {
        System.out.printf("Отправляем ворона из королевства %s в королевство %s\n", kingdom1.getName(), kingdom2.getName());

        try {
            Thread.sleep(random.nextLong(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextBoolean()) {
            return "Ворон долетел из королевства " + kingdom1.getName() + " в королевство " + kingdom2.getName();
        }

        throw new IllegalArgumentException("Ворон сбился с пути. " +
                "Письмо из королевства " + kingdom1.getName() + " в королевство " + kingdom2.getName() + " не доставлено");
    }
}
