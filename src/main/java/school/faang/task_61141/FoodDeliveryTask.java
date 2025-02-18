package school.faang.task_61141;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class FoodDeliveryTask implements Runnable {
    private final Random random = new Random();
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType().name();
        System.out.printf("%s gets %d %s\n", character, foodAmount, foodType);
        try {
            Thread.sleep(random.nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodType + " из-за прерывания.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("%s's eating %d %s\n", character, foodAmount, foodType);
    }

    private FoodType getFoodType() {
        FoodType[] foodFoodTypes = FoodType.values();
        return foodFoodTypes[random.nextInt(foodFoodTypes.length)];
    }

}
