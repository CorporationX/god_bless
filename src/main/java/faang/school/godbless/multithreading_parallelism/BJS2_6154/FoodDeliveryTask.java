package faang.school.godbless.multithreading_parallelism.BJS2_6154;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s gets %d of %s%n", this.character, this.foodAmount, food);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s eats %d of %s%n", this.character, this.foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
