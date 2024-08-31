package pump.up.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final long TIME_TO_GATHER = 800L;

    public static void main(String[] args) {
        AtomicInteger sumAllIngredients = new AtomicInteger(0);
        List<Potion> potions = new ArrayList<>(List.of(
            new Potion("Восстановление здоровья", 2),
            new Potion("Зелье невидимости", 5),
            new Potion("Зелье регенерации", 7),
            new Potion("Восстановление маны", 3),
            new Potion("Восстановление выносливости", 8),
            new Potion("Увеличение силы", 4)
        ));

        List<CompletableFuture<Void>> futuresList = potions.stream()
            .map((potion) -> gatherIngredients(potion, sumAllIngredients))
            .toList();

        CompletableFuture.allOf(futuresList.toArray(CompletableFuture[]::new)).join();

        System.out.println("Всего ингридиентов: " + sumAllIngredients.get());
    }

    private static CompletableFuture<Void> gatherIngredients(Potion potion, AtomicInteger sumAllIngredients) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * TIME_TO_GATHER);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            return potion.getRequiredIngredients();
        }).thenAccept(sumAllIngredients::getAndAdd);
    }
}
