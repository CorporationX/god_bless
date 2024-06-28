package faang.school.godbless.DownloadAlchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int COUNT_THREAD = 4;
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Potion> potions = createPotion();
        Integer r = allIngredients(potions);
        System.out.println(r);
        executorService.shutdown();
    }

    public static Integer allIngredients(List<Potion> potions) throws ExecutionException, InterruptedException {
        AtomicInteger allPotion = new AtomicInteger(0);
        CompletableFuture<Void> getPotion = CompletableFuture.allOf(
                potions.stream()
                        .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion), executorService)
                                .thenAccept(allPotion::addAndGet))
                        .toArray(CompletableFuture[]::new));
        getPotion.join();
        return allPotion.get();
    }

    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(potion.getRequiredIngredients()));
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка при сборе ингридиентов");
        }
        return potion.getRequiredIngredients();
    }

    private static List<Potion> createPotion() {
        return List.of(
                new Potion("Ласточка", 2),
                new Potion("Гром", 3),
                new Potion("Черная кровь", 3),
                new Potion("Самогон", 4));
    }
}