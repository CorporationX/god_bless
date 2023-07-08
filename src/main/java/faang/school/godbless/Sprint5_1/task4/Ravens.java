package faang.school.godbless.Sprint5_1.task4;

import java.util.concurrent.CompletableFuture;

public class Ravens {
    public static CompletableFuture<String> sendRaven(Kingdom senderKingdom, Kingdom recipientKingdom) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 0.3) {
                throw new RuntimeException("Plane shot down the raven flying from " + senderKingdom.getName() +
                        " to " + recipientKingdom.getName());
            } else {
                return senderKingdom.sendMessage(recipientKingdom);
            }
        }).handle((result, ex) -> ex == null ? result : ex.getMessage());

        completableFuture.thenAccept(System.out::println).join();

        return completableFuture;
    }

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");
        Kingdom kingdom3 = new Kingdom("Kingdom 3");

        sendRaven(kingdom1, kingdom2);
        sendRaven(kingdom2, kingdom3);
        sendRaven(kingdom3, kingdom1);
        sendRaven(kingdom1, kingdom3);
        sendRaven(kingdom2, kingdom1);
        sendRaven(kingdom3, kingdom2);
    }
}
