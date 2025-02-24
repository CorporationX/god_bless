package school.faang.BJS2_61171;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int MIN_DELAY = 1000;
    private static final int MAX_DELAY = 5000;
    private static final Random RANDOM = new Random();
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        try {
            FoodType foodType = getFoodType();
            System.out.printf("%s получает %d %s\n", character, foodAmount, foodType.name());
            Thread.sleep(RANDOM.nextInt(MIN_DELAY, MAX_DELAY));
            System.out.printf("%s ест %s\n", character, foodType.name());
        } catch (InterruptedException e) {
            System.out.printf("Доставка еды прервана для %s", character);
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }
}
