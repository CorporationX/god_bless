package faang.school.godbless.async.sendRaven;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");

        System.out.println(sendRaven(kingdom1, kingdom2));
    }

    public static String sendRaven(Kingdom kingdom1, Kingdom kingdom2) {
        boolean ifDelivered = new Random().nextBoolean();

        CompletableFuture<String> ravenFuture = CompletableFuture.supplyAsync(() -> {
            if (!ifDelivered) {
                throw new IllegalArgumentException("Raven didn't deliver the message");
            }
            return kingdom1.sendMessage(kingdom2);
        }).handle((res, ex) -> {
            if (ex != null) {
                return ex.getMessage();
            }
            return res;
        });

        try {
            return ravenFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
