package school.faang.bjs2_91111;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
    private static final int MAX_DELIVERY_TIME = 5;

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        try {
            FoodType food = getFoodType();
            System.out.println(character + " получает " + foodAmount + " " + food.getRussianName());

            int delaySeconds = random.nextInt(MAX_DELIVERY_TIME) + 1;
            Thread.sleep(delaySeconds * 1000);

            System.out.println(character + " ест " + foodAmount + " " + food.getRussianName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
