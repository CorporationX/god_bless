package school.faang.bjs2_89541;

import lombok.SneakyThrows;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final Random random = new Random();
    private static final int COUNT_SLEEP = 5000;


    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @SneakyThrows
    public void run() {
        FoodType food = getFoodType();
        System.out.printf("%s receives %d %s%n", character, foodAmount, food);
        Thread.sleep(COUNT_SLEEP);
        System.out.printf("%s eat %d %s%n", character, foodAmount, food);
    }
}
