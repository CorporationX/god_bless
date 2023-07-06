package faang.school.godbless.sprint5.sendRaven;

import faang.school.godbless.sprint5.sendRaven.classes.Kingdom;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Kingdom firstKingdom = new Kingdom("First Kingdom");
        Kingdom secondKingdom = new Kingdom("Second Kingdom");

        for (int i = 0; i < 20; i++){
            CompletableFuture<String> letter = CompletableFuture.supplyAsync(() -> firstKingdom.sendRaven(secondKingdom));
            CompletableFuture<String> result = letter.handle((msg, ex) -> {
                if (ex != null) {
                    return ex.getMessage();
                }
                return msg;
            });

            result.thenAccept(System.out::println);
        }
    }
}
