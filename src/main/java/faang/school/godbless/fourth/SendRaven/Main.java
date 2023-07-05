package faang.school.godbless.fourth.SendRaven;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("The Vale of Arryn");
        Kingdom kingdom2 = new Kingdom("The Riverlands");
        Kingdom kingdom3 = new Kingdom("The Stormlands");
        Kingdom kingdom4 = new Kingdom("The Crownlands");

        CompletableFuture<String> futureResult1 = CompletableFuture.supplyAsync(() -> kingdom1.sendMessage(kingdom2,
                        "Hi, guys."))
                .handle((result, throwable) -> {
                    if (throwable != null) {
                        return "An error occurred: " + throwable.getMessage();
                    } else {
                        return result;
                    }
                });

        CompletableFuture<String> futureResult2 = CompletableFuture.supplyAsync(() -> kingdom3.sendMessage(kingdom4,
                        "Hi, how are you? Sorry I can't talk on my iPhone 12, my Bentley is waiting for me."))
                .handle((result, throwable) -> {
                    if (throwable != null) {
                        return "An error occurred:" + throwable.getMessage();
                    } else {
                        return result;
                    }
                });

        System.out.println(futureResult1.join());
        System.out.println(futureResult2.join());
    }
}
