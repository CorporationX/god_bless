package Multithreading.bc3101_Send_a_Raven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    public void sendRaven(Kingdom kingdom1, Kingdom kingdom2) {

        CompletableFuture<String> result = CompletableFuture
                .supplyAsync(() -> kingdom2.sendMessage(kingdom1))
                .handle(null);

        String res = result.join();
        System.out.println(res);
    }
}

