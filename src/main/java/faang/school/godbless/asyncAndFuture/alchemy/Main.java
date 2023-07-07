package faang.school.godbless.asyncAndFuture.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Producer producer = new Producer();
        List<Potion> potions = List.of(
                new Potion("Potion #1", 35),
                new Potion("Potion #2", 51),
                new Potion("Potion #3", 17)
        );

        CompletableFuture.allOf(producer.doPotions(potions).toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println(producer.getIngredientsNumber())).join();
        producer.shutdown();
    }
}
