package school.faang.BJS2_61171;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final Random random = new Random();
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        try {
            FoodType foodType = getFoodType();
            System.out.printf("%s получает %d %s\n", character, foodAmount, foodType.name());
            Thread.sleep(random.nextInt(1000, 5000));
            System.out.println(character + " ест " + foodType.name());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodFoodTypes = FoodType.values();
        return foodFoodTypes[random.nextInt(foodFoodTypes.length)];
    }
}
