package faang.school.godbless.feed_peter_griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;


    @Override
    public void run() {
        System.out.printf("%s receiving %d %s\n", this.character, this.foodAmount, getFoodType());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("Food delivering to %s failed: %s", this.character, Thread.currentThread().getName()));
        }
        System.out.printf("%s successfully eating %d %s\n", this.character, this.foodAmount, getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
