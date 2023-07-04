package faang.school.godbless.sprint4.raven;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom = new Kingdom("Kingdom");
        Kingdom otherKingdom = new Kingdom("Other Kingdom");

        sendRaven(kingdom, otherKingdom);
    }

    public static CompletableFuture sendRaven(Kingdom kingdom, Kingdom otherKingdom) {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {

            if (Math.random() < 0.5) {
                kingdom.sendMessage(otherKingdom, "Hello from " + kingdom.getName());
            } else {
                throw new RuntimeException("Something went wrong");
            }
            return kingdom;
        });
        future.handle((message, ex) -> {
            if (ex != null) {
                System.out.println("Raven delivery failed");
            } else
                System.out.println("Raven delivery succeeded");
            return message;
        });
        future.join();
        return future;
    }

}
