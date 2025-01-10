package school.faang.task_50701;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

@Slf4j
public class Main {

    public static void main(String... args) {
        KingdomPost post = new KingdomPost();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");

        BiFunction<String, Throwable, Void> handleResult = (result, ex) -> {
            if (ex != null) {
                log.error(ex.getMessage());
            } else {
                log.info(result);
            }
            return null;
        };

        CompletableFuture<String> message1 = post.sendRaven(winterfell, kingsLanding);
        CompletableFuture<String> message2 = post.sendRaven(kingsLanding, winterfell);

        message1.handle(handleResult);

        message2.handle(handleResult);

        try {
            CompletableFuture.allOf(message1, message2).join();
        } finally {
            post.shutdown();
        }
    }
}
