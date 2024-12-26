package school.faang.task_48001;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Getter
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        if (character.isEmpty()) {
            throw new IllegalArgumentException("Character cannot be empty");
        }
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    private int getRandomDelay() {
        return new Random().nextInt(5);
    }

    @Override
    public void run() {
        try {
            String foodType = getFoodType();
            int delay = getRandomDelay() * 1000;
            log.info("{} is getting {} {}", character, foodAmount, foodType);
            Thread.sleep(delay);
            log.info("{} is eating {} {}", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Food delivery for " + character + " is interrupted.");
        }
    }
}
