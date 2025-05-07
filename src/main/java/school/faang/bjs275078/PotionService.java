package school.faang.bjs275078;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class PotionService {

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Gather ingredients is started..." + potion.getName());
                Thread.sleep(2000);
                System.out.println("Gathering is finished");
            } catch (InterruptedException e) {
                System.out.println("An error occurred");
                Thread.currentThread().interrupt();
                throw new IllegalArgumentException(e);
            }
            return potion.getRequiredIngredients();
        });
    }

    public void gatherAllIngredients(List<Potion> potions) {

        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Void>> list = potions.stream()
                .map(potion -> gatherIngredients(potion)
                        .thenAccept(totalIngredients::getAndSet))
                .toList();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
        allTasks.join();
    }
}
