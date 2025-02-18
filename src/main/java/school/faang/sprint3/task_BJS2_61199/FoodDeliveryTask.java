package school.faang.sprint3.task_BJS2_61199;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private static final int MIN_SECOND = 1;
    private static final int MAX_SECOND = 5;

    private final Random random;
    private final String character;
    private final FoodType foodType;
    private final int foodAmount;

    public FoodDeliveryTask(String character) {
        random = new Random();
        FoodType[] foodFoodTypes = FoodType.values();
        this.foodType = foodFoodTypes[random.nextInt(foodFoodTypes.length)];
        this.character = character;
        foodAmount = random.nextInt(1, 50);
    }

    @Override
    public void run() {
        System.out.printf("%s получает %d %s\n", character, foodAmount, foodType);
        sleepRandomSeconds(MIN_SECOND, MAX_SECOND);
        System.out.printf("%s ест %d %s\n", character, foodAmount, foodType);
    }

    private void sleepRandomSeconds(int start, int end) {
        try {
            Thread.sleep(random.nextInt(start, end + 1) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
