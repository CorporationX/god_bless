package faang.school.godbless.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private final static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        List<Potion> potionList = List.of(new Potion("Luck", new AtomicInteger(15)),
                new Potion("Strength", new AtomicInteger(10)),
                new Potion("Agility", new AtomicInteger(12)),
                new Potion("Charizma",new AtomicInteger(8)),
                new Potion("Perception", new AtomicInteger(20)));
        List<CompletableFuture<AtomicInteger>> futurePotions = potionList.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executorService))
                .toList();
        CompletableFuture.allOf(futurePotions.toArray(CompletableFuture[]::new)).join();
        System.out.println(futurePotions.stream().mapToInt(future -> {
            try {
                return future.get().get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).sum());
    }

    public static AtomicInteger gatherIngredients(Potion potion) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.getRequiredIngridients();
    }
}
