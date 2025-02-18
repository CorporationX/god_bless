package school.faang.sprint3.task_BJS2_61199;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private final Random random;
    private String character;
    private FoodType foodType;
    private int foodAmount;

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
        sleepRandomSeconds(1, 5);
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
