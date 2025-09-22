package school.faang.module3.griffin;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        FoodType rndFood = getFoodType();
        System.out.printf("%s получает %d %s%n", character, foodAmount, rndFood);
        try {
            Thread.sleep(getDelay());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("%s was interrupted%n", Thread.currentThread().getName());
        }
        System.out.printf("%s съел %d %s%n", character, foodAmount, rndFood);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    private long getDelay() {
        return random.nextInt(1, 5) * 1000L;
    }
}
