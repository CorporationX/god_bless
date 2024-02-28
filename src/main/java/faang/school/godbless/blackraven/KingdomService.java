package faang.school.godbless.blackraven;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KingdomService {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public CompletableFuture<Void> sendRaven(Kingdom kingdom1, Kingdom kingdom2) {
        return CompletableFuture.runAsync(() -> kingdom1.sendMessage(kingdom2), EXECUTOR_SERVICE)
                .handle(this::exceptionHandle);
    }

    public void shutdownAndAwaitExecution(Long minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitExecution(minutes);
    }

    private <T extends Throwable> Void exceptionHandle(Void result, T exception) {
        if (exception == null) {
            System.out.println("Message successfully sent");
        } else {
            System.out.println(exception.getMessage());
        }
        return result;
    }

    private void awaitExecution(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
