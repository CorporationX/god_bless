package faang.school.godbless.Sprint4Future.SendARaven;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@Getter
public class Kingdom {
    private String name;
    private String message;

    public Kingdom(String name) {
        this.name = name;
    }

    public CompletableFuture<String> sendMessage(Kingdom kingdom, String message){
        return CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5){
                this.message = message;
                return "Message " + message +  " delivered to " + kingdom.name;
            } else {
                throw new RuntimeException("Message don't send");
            }
        });
    }
}
