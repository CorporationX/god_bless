package school.faang.task_51065;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Potion {
    private static final Logger logger = LoggerFactory.getLogger(Potion.class);
    private final String name;
    private final int requiredIngredients;

    public int gatherIngredients() {
        try {
            logger.info("Collecting ingredients for the potion: {}", name);
            Thread.sleep(requiredIngredients * 1000L);
            return requiredIngredients;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted while gathering ingredients for potion: {}", name, e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}