package faang.school.godbless.sprint3.BJS2_23976;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s receives: %d x %s %n", character, foodAmount, foodType);

        try {
            Thread.sleep(new Random().nextLong(1, 6) * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s is eating %d x %s %n", character, foodAmount, foodType);
    }
}
