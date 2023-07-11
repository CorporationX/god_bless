package faang.school.godbless.Sprint_5.Multithreading_Async.Raven;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void sendRaven(Kingdom k1, Kingdom k2) {
        CompletableFuture<String> letter = CompletableFuture.supplyAsync(() -> k1.sendMessage(k2)).handle((msg, ex) -> {
            if (ex != null) {
                return ex.getMessage();
            }
            return msg;
        });

        letter.thenAccept(System.out::println).join();
    }

    public static void main(String[] args) {
        Kingdom k1 = new Kingdom("first");
        Kingdom k2 = new Kingdom("second");

        sendRaven(k1 ,k2);

    }
}
