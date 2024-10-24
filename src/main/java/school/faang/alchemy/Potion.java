package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Potion {
    private String name;
    private int requiredIngredientsAmount;

    public int gatherIngredients() {
        try {
            log.info("Started gathering ingredients for potion: " + this.getName());
            Thread.sleep(1000L * this.getRequiredIngredientsAmount());
            log.info("Gathered all " + this.getRequiredIngredientsAmount() + " required ingredients for potion: " + this.getName());
            return this.getRequiredIngredientsAmount();
        } catch (InterruptedException e) {
            log.error("Thread had been interrupted during ingredients gathering for potion " + this.getName(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ingredients gathering was interrupted", e);
        }
    }
}