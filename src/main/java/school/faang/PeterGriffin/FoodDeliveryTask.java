package school.faang.PeterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;
    private static Random random = new Random();

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
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
