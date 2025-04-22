package school.faang.peter_griffen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
@ToString
@Getter
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.println(String.format("%s получает %d %s", character, foodAmount, foodType.getDisplayName()));
        log.debug("Thread {} is executing for {}", Thread.currentThread().getName(), character);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println(String.format("%s ест %d %s", character, foodAmount, foodType.getDisplayName()));
    }
}
