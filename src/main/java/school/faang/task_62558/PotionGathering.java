package school.faang.task_62558;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PotionGathering {
    private static final int MILLISECONDS_PER_SECOND = 1_000;
    private static final String START_GATHERING_MESSAGE = "Сбор ингредиентов для зелья \"{}\" запущен";
    private static final String END_GATHERING_MESSAGE = "Сбор ингредиентов для зелья \"{}\" завершен";
    private static final String INTERRUPT_GATHERING_MESSAGE = "Сбор ингредиентов для зелья \"{}\" прерван";
    private static final String TOTAL_INGREDIENTS_MESSAGE = "Общее количество собранных ингредиентов: {}";

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 10),
                new Potion("Mana Potion", 5),
                new Potion("Stamina Potion", 2)
        );

        gatherAllIngredients(potions);
    }

    public static CompletableFuture<Integer> gatheringIngredients(@NonNull Potion potion) {
        int gatheringTime = potion.getRequiredIngredients() * MILLISECONDS_PER_SECOND;
        String potionName = potion.getName();
        return CompletableFuture.supplyAsync(() -> {
            log.info(START_GATHERING_MESSAGE, potionName);
            try {
                Thread.sleep(gatheringTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(INTERRUPT_GATHERING_MESSAGE, potionName);
                throw new RuntimeException(e);
            }
            log.info(END_GATHERING_MESSAGE, potionName);
            return potion.getRequiredIngredients();
        });
    }

    public static void gatherAllIngredients(@NonNull List<Potion> potions) {
        AtomicInteger totalIngredients = new AtomicInteger(0);

        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatheringIngredients)
                .toList();
        futures.forEach(future -> future.thenApply(totalIngredients::addAndGet));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        int total = totalIngredients.get();
        log.info(TOTAL_INGREDIENTS_MESSAGE, total);
    }
}
