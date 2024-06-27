package faang.school.godbless.SendTheRavenIn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int COUNT_THREAD = 4;
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Винтерфел");
        Kingdom kingdom2 = new Kingdom("Екатеринбург");
        sendRaven(kingdom1, kingdom2);
        executorService.shutdown();

    }

    private static void sendRaven(Kingdom kingdomOne, Kingdom kingdomTwo) {
        CompletableFuture.runAsync(() ->
                kingdomOne.sendMessage(kingdomTwo), executorService).handle((result, ex) -> {
            if (ex != null) {
                return ex.getMessage();
            } else {
                return result;
            }
        });
    }
}
