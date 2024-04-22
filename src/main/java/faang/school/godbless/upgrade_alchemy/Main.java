package faang.school.godbless.upgrade_alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Test1", 2),
                new Potion("Test2", 3),
                new Potion("Test3", 4),
                new Potion("Test4", 10),
                new Potion("Test5", 100),
                new Potion("Test6", 30),
                new Potion("Test7", 40)
        );
        ExecutorService executorService = Executors.newFixedThreadPool(potions.size());
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        AtomicInteger atomicInteger = new AtomicInteger();

        potions.forEach(potion ->
                futures.add(CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executorService)
                        .thenApply(atomicInteger::addAndGet)
                ));

//        futures.stream()
//                .map(CompletableFuture::join)
//                .forEach(atomicInteger::addAndGet);

        // CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        // В задачке сказано использовать CompletableFuture.allOf(), мне как то не нравится, как выглядит эта запись.

        futures.forEach(CompletableFuture::join);

        // Также мы можем просто подождать завершения задач, а логику самого сложения вынести на 28 строку
        // с помощью метода thenApply, есть ли какая-то принципиальная разница между этим подходом и тем, что написан на 31 строке?
        // Все, сам понял разницу, если оставить текущую реализацию, то сложение происходит в разных потоках,
        // если использовать реализацию с 31 строчки, то все будет в main)

        executorService.shutdown();
        System.out.println(atomicInteger);
    }

    public static Integer gatherIngredients(Potion potion) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        return potion.getRequiredIngredients();
    }
}