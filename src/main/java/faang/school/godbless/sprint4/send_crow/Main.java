package faang.school.godbless.sprint4.send_crow;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Kingdom k1 = new Kingdom("Lannisters");
        Kingdom k2 = new Kingdom("Starks");
        Kingdom k3 = new Kingdom("Westeros");

        List<CompletableFuture<String>> futures = List.of(
                sendRaven(k1, k2),
                sendRaven(k2, k3),
                sendRaven(k1, k3)
        );

        futures.forEach(cf -> cf.handle((result, throwable) -> {
                    if (throwable != null) {
                        System.err.println(throwable.getMessage());
                        return throwable.getMessage();
                    }
                    return result;
                })
                .thenAccept(System.out::println)
                .join()
        );
    }

    static CompletableFuture<String> sendRaven(Kingdom from, Kingdom to) {
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        int idx = generator.nextInt(4);
        if (idx < 2) {
            return CompletableFuture.failedFuture(new IllegalStateException(String.format("Raven from '%s' to '%s' not delivered!", from.getName(), to.getName())));
        } else {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    return from.sendMessage(to);
                } catch(InterruptedException e) {
                    throw new RuntimeException("Thread interrupted!");
                }
            });
        }
    }
}
