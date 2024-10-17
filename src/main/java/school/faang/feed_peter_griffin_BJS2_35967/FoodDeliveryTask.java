package school.faang.feed_peter_griffin_BJS2_35967;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int WAIT_TIME_FROM = 1000;
    private static final int WAIT_TIME_TO = 5000;

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s gets %d %s\n", character, foodAmount, foodType);
        try {
            Thread.sleep(new Random().nextInt(WAIT_TIME_FROM, WAIT_TIME_TO));
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("%s eats %d %s\n", character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
