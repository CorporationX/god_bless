package school.faang;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    public final String character;
    public final int foodAmount;

    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodFoodTypes = FoodType.values();
        return foodFoodTypes[random.nextInt(foodFoodTypes.length)];
    }
    public enum FoodType {
        PIZZA,
        BURGER,
        TACO
    }

    @Override
    public void run() {
        String foodType = getFoodType().name();
        try {
            log.info(character + " получает " + foodAmount + " " + foodType);
            int foodAmount = random.nextInt(100) + 1;
            Thread.sleep(1000 + random.nextInt(4000));
            log.info(character + " ест " + foodAmount + " " + foodType);
        }
            catch (InterruptedException e) {
                log.info("Доставка " + foodAmount + foodType + " для " + character + " была прервана");
                Thread.currentThread().interrupt();
            }

    }
}
