package sprint5.crow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Kingdom newKingdom = new Kingdom("New Kingdom");
        Kingdom springKingdom = new Kingdom("Spring Kingdom");

        CompletableFuture<String> firstResult = newKingdom.sendRaven(springKingdom, "Secret message");
        CompletableFuture<String> secondResult = springKingdom.sendRaven(newKingdom, "Not secret message");

        try {
            System.out.println(firstResult.get());
            System.out.println(secondResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
