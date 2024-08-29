package faang.school.godbless.sendingRavens;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RavenMail {
    public static CompletableFuture<String> sendRavenMail(Kingdom from, Kingdom to, String message) {
        return CompletableFuture.supplyAsync(() -> {
            if (message.isEmpty()) {
                throw new IllegalArgumentException("Message cannot be empty");
            }
            from.sendMessage(to, message);
            return "Message from " + from.getName() + " to " + to.getName() + ": " + message;
        });
    }

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("The North");
        Kingdom kingdom2 = new Kingdom("The Stormlands");

        CompletableFuture<String> future = sendRavenMail(kingdom1, kingdom2, "text of message")
                .handle((s, t) -> s != null ? s : t.getMessage());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
