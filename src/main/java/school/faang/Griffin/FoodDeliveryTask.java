package school.faang.Griffin;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        String foodType = getFoodType().toString();
        try {
            System.out.println(character + " получает " + foodAmount + " " + foodType);
            Thread.sleep(5000);
            System.out.println(character + " ест " + foodAmount + " " + foodType);

        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodAmount + " из-за прерывания");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodFoodTypes = FoodType.values();
        return foodFoodTypes[random.nextInt(foodFoodTypes.length)];
    }
}