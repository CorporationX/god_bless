package faang.school.godbless.alchimy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    private static int gatherIngredients(Potion potion){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return potion.getRequiredIngredients();
    }

    public static void main(String[] args) {
        Potion potion1 = new Potion("first", 5);
        Potion potion2 = new Potion("second", 8);
        Potion potion3 = new Potion("third", 6);
        Potion potion4 = new Potion("fourth", 7);
        List<Potion> potions = List.of(potion1, potion2, potion3, potion4);

        List<CompletableFuture<Integer>> futureList = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion)))
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));

        allFutures.thenApply(v -> futureList.stream()
                .map(CompletableFuture::join)
                .reduce( (t1, t2) -> {
                    AtomicInteger result = new AtomicInteger(0);
                    result.addAndGet(t1+t2);
                    return result.get();
                }).orElseThrow())
                .thenAccept(System.out::println)
                .join();
    }
}
