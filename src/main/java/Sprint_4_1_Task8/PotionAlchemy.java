package Sprint_4_1_Task8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class PotionAlchemy {
    List<Potion> potionList;
    public CompletableFuture<Integer> gatherIngredients(Potion potion){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
        return future;
    }

    public static void main(String[] args) {
        List<Potion> potionList = List.of(
                new Potion("Potion1", 3),
                new Potion("Potion2", 8),
                new Potion("Potion3", 7)
        );
        PotionAlchemy potionAlchemy = new PotionAlchemy(potionList);
        List<CompletableFuture<Integer>> collect = potionList.stream()
                .map(potionAlchemy::gatherIngredients)
                .toList();
        AtomicInteger i = new AtomicInteger();
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(collect.toArray(new CompletableFuture[potionList.size()]));
        voidCompletableFuture.thenApply((x) -> {
            collect.forEach((f) -> {
                try {
                    i.addAndGet(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            return null;
        }).join();
        System.out.println(i);
    }
}
