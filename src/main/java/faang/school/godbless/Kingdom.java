package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public CompletableFuture<String> sendMessage(Kingdom kingdom){
        CompletableFuture<String> future = new CompletableFuture<>();
        sendRaven(this, kingdom)
                .thenApply(message -> {
                    System.out.println("Message have delivered from " + this.getName() + " to " + kingdom.getName() + ": " + message);
                    return message;
                })
                .exceptionally(ex ->{
                    return "Message have not delivered from " + this.getName() + " to " + kingdom.getName();
                })
                .thenAccept(result -> future.complete(result));

        return future;
    }


    private CompletableFuture<String> sendRaven(Kingdom from, Kingdom to){
        CompletableFuture<String> future = new CompletableFuture<>();
        double random = Math.random();

        if(random < 0.5){
            String message = "Message from " + from.getName() + " to  " + to.getName();
            future.complete(message);
        } else {
            future.completeExceptionally(new RuntimeException("Raven is dead. Fcking ravenNet, for what i pay shekely!!!"));
        }

        return future;
    }


}
