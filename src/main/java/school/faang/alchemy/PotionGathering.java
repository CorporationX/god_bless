package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class PotionGathering {

    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
        try {
            CompletableFuture<Integer> totalIngredientsFuture = Potion.gatherAllIngredients(potions);
            int totalIngredients = totalIngredientsFuture.get();
            log.info(String.format("Общее количество собранных ингредиентов: %d", totalIngredients));
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            log.warn("Произошла ошибка при выполнении операции", e);
        }
    }
}
