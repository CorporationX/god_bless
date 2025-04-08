package school.faang.bjs248633;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Food(String foodName) {

    public Food(String foodName) {
        if (foodName == null || foodName.trim().isEmpty()) {
            log.warn("Attempted to create Food with invalid name: '{}'", foodName);
            throw new IllegalArgumentException("Food name cannot be null or empty.");
        }
        this.foodName = foodName;
        log.debug("Food created with name: {}", this.foodName);
    }
}

