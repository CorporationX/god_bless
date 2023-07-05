package faang.school.godbless.games.of.thrones;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom kingdom) {
        return "message from " + kingdom.getName();
    }

    public String sendRaven(Kingdom kingdom1, Kingdom kingdom2) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> sendMessage(kingdom1))
                .handle((s, throwable) -> handler(s, throwable));
        String message = future.get();

        return message + " delivered in " + kingdom2.getName();
    }

    private String handler(String result, Throwable throwable) {
        if (!(result == null)) {
            return result;
        }
        return throwable.getMessage();
    }
}
