package school.faang.Griffin;

import lombok.RequiredArgsConstructor;
import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int DELAY_MS = 5000;

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        String foodType = getFoodType().toString();
        try {
            System.out.printf("%s получает %d %s%n", character, foodAmount, foodType);
            Thread.sleep(DELAY_MS);
            System.out.println(character + " ест " + foodAmount + " " + foodType);

        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + foodAmount + " из-за прерывания");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}