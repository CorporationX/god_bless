package faang.school.godbless.crow;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@AllArgsConstructor
public class Kingdom {
    private String name;

    public static String sendMessage(Kingdom kingdom) {
        return "атя-тя сообщение могут прочитать только в королевстве " + kingdom.name;
    }

    public static CompletableFuture sendRaven(Kingdom kingdom1, Kingdom kingdom2) throws ExecutionException, InterruptedException, TimeoutException {
        int rand = (int) (Math.random() * 2);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (rand == 0) {
                System.out.println("Ворон полетел из " + kingdom1.name + " в " + kingdom2.name + " с сообщением: " + sendMessage(kingdom2));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Ворон доставил письмо";
            } else {
                return "Ворон не доставил сообшение";
            }
        });

        completableFuture.handle((s, throwable) -> {
            if (throwable != null) {
                System.out.println("Ворон не доставил сообшение");
            } else {
                System.out.println("Ворон доставил письмо");
            }
            return s;
        });
        completableFuture.get(30, TimeUnit.SECONDS);
        return completableFuture;
    }
}
