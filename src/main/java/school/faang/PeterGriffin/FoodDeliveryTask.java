package school.faang.PeterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static Random random = new Random();

    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        int foodIndex = random.nextInt(foodTypes.length);
        return foodTypes[foodIndex];
    }

    public void run() {
        String foodType = getFoodType();
        System.out.printf("Started delivery of %d %s for %s\n", foodAmount, foodType, character);
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong", e);
        }
        System.out.printf("%d of %s has been delivered for %s\n", foodAmount, foodType, character);
    }
}
