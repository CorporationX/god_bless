package faang.school.godbless.SendCrow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Kingdom kingdom1 = new Kingdom("королевство 1");
        Kingdom kingdom2 = new Kingdom("королевство 2");

        CompletableFuture<Void> future = kingdom1.sendMessage(kingdom2, executor).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("все печально");
                return result;
            }
            else {
                System.out.println("всё отлично");
            }
            return result;
        });;

        future.join();

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
