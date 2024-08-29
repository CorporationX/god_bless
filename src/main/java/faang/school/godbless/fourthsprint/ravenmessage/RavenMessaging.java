package faang.school.godbless.fourthsprint.ravenmessage;

import java.util.concurrent.CompletableFuture;

public class RavenMessaging {
    public static CompletableFuture<String> sendRaven(Kingdom from, Kingdom to) {
        return CompletableFuture.supplyAsync(() -> from.sendMessage(to))
                .handle((result, ex) -> {
                    if (ex != null) {
                        return "Fail: " + ex.getMessage();
                    }
                    return result;
                });
    }

    public static void main(String[] args) {
        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("KingsLanding");
        Kingdom dorne = new Kingdom("Dorne");

        CompletableFuture<String> raven1 = sendRaven(winterfell, kingsLanding);
        CompletableFuture<String> raven2 = sendRaven(kingsLanding, dorne);
        CompletableFuture<String> raven3 = sendRaven(dorne, winterfell);

        CompletableFuture.allOf(raven1, raven2, raven3)
                .thenRun(() -> {
                    raven1.thenAccept(System.out::println);
                    raven2.thenAccept(System.out::println);
                    raven3.thenAccept(System.out::println);
                }).join();
    }
}
