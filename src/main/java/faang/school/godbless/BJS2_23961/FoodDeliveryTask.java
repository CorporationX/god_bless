package faang.school.godbless.BJS2_23961;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%S gets %d %S\n", character, foodAmount, foodType);
        try {
            Thread.sleep(getMilliseconds());
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread error");
        }
        System.out.printf("%S eats %d %S\n", character, foodAmount, foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    private int getMilliseconds() {
        return (1 + random.nextInt(5)) * 1000;
    }
}
