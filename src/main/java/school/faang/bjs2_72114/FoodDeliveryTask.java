package school.faang.bjs2_72114;

import lombok.Data;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();

        System.out.printf("%s получает %d %s\n", character, foodAmount, foodType);
        try {
            Thread.sleep(random.nextInt(5));
            System.out.printf("%s ест %d %s\n", character, foodAmount, foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
