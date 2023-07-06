package Multithreading.bc3101_Send_a_Raven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Getter
@Setter
public class Kingdom {
    private String name;
    private String message;


    public String sendMessage(Kingdom kingdom) {
        return kingdom.getMessage();
    }

    public CompletableFuture<String> sendRaven(Kingdom kingdom1, Kingdom kingdom2) {
        Random random = new Random();

        return CompletableFuture
                .supplyAsync(() -> {
                    if (random.nextBoolean()) {
                        throw new RuntimeException();
                    }
                    return kingdom2.sendMessage(kingdom1);
                });
    }
}

