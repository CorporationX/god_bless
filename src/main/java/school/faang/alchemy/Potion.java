package school.faang.alchemy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Potion(String name, int ingredients) {
    public int collectingIngredients() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Поток был прерван.");
            Thread.currentThread().interrupt();
        }
        return ingredients;
    }
}
