package faang.school.godbless.SendARaven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RavenSender {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Kingdom kingdom1 = new Kingdom("kingdom1");
        Kingdom kingdom2 = new Kingdom("kingdom2");
        Kingdom kingdom3 = new Kingdom("kingdom3");
        Kingdom kingdom4 = new Kingdom("kingdom4");

        sendRaven(kingdom1, kingdom2, "Simple message");
        sendRaven(kingdom3, kingdom4, "Message with poison");
    }

    public static void sendRaven(Kingdom sender, Kingdom receiver, String message) throws ExecutionException, InterruptedException {
        CompletableFuture<?> completableFuture = CompletableFuture.supplyAsync(() -> sender.sendMessage(receiver, message)).
                handle((s, t) -> s != null ? s : t.getMessage());

        System.out.println(completableFuture.get());
    }
}
