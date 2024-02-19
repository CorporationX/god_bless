package faang.school.godbless.r_edzie.parallelism.griffin;

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
        String food = getFoodType();
        System.out.printf("%s получает %d %s%n", character, foodAmount, food);
        try {
            Thread.sleep(foodAmount * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s ест %d %s%n", character, foodAmount, food);
    }
}
