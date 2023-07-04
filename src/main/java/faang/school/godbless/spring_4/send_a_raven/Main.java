package faang.school.godbless.spring_4.send_a_raven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService POOL = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {

        Kingdom kingdom = new Kingdom("Gold coin", null);
        Kingdom kingdom1 = new Kingdom("Fast fish", "a snowstorm is coming");

        CompletableFuture<String> message1 = sendRaven(kingdom1, kingdom);

        CompletableFuture<String> message2 = sendRaven(kingdom, kingdom1);

        message1.thenAccept(message -> System.out.println(message)).handle((res, ex) -> {
            if (ex != null) {
                System.out.println(ex.getMessage());
                return "null";
            }
            return res;
        });

        message2.thenAccept(message -> System.out.println(message)).handle((res, ex) -> {
            if (ex != null) {
                System.out.println(ex.getMessage());
                return "null";
            }
            return res;
        });

        POOL.shutdown();
    }

    private static CompletableFuture<String> sendRaven(Kingdom kingdomFrom, Kingdom kingdomTo) {
        return CompletableFuture.supplyAsync(() -> kingdomFrom.sendMessage(kingdomTo), POOL);
    }
}
