package school.faang.downloadalchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadMyAlchemy {
    private static Object locker = new DownloadMyAlchemy();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Potion> allPotions = List.of(new Potion("Kefir", 10),
                new Potion("Katyik", 10),
                new Potion("Mazony", 6));
        gatherAllIngredients(allPotions);
    }

    private static int gatherIngredients(Potion potion) throws InterruptedException {
        Thread.sleep(potion.requiredIngredients() * 100L);
        return potion.requiredIngredients();
    }

    private static void gatherAllIngredients(List<Potion> allPotions) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<CompletableFuture<Integer>> completableFuturesPotions = allPotions.stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(potion.requiredIngredients() * 100L);
                                return gatherIngredients(potion);
                            } catch (InterruptedException e) {
                                throw new IllegalStateException(
                                        "Во время выполнения метода gatherIngredients произошла ошибка", e);
                            }
                        }, service)).toList();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(completableFuturesPotions.toArray(new CompletableFuture[0]));
        CompletableFuture<Integer> sumFuture = allOf.thenApply(v -> completableFuturesPotions.stream()
                .map(CompletableFuture::join)
                .mapToInt(Integer::intValue)
                .sum());
        System.out.println(sumFuture.join());
        service.shutdown();
    }
}
