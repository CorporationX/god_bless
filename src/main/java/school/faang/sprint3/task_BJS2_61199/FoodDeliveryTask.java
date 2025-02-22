package school.faang.sprint3.task_BJS2_61199;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private static final int MIN_SECOND = 1;
    public static final int MAX_SECOND = 5;

    private final Random random;
    private final String character;
    private final FoodType foodType;
    private final int foodAmount;

    public FoodDeliveryTask(String character) {
        random = new Random();
        this.foodType = getFoodType();
        this.character = character;
        foodAmount = random.nextInt(1, 50);
    }

    @Override
    public void run() {
        System.out.printf("%s получает %d %s\n", character, foodAmount, foodType);
        sleepRandomSeconds();
        System.out.printf("%s ест %d %s\n", character, foodAmount, foodType);
    }

    private void sleepRandomSeconds() {
        try {
            Thread.sleep(random.nextInt(MIN_SECOND, MAX_SECOND + 1) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
