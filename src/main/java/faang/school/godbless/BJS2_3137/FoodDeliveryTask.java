package faang.school.godbless.BJS2_3137;

import lombok.Data;
import lombok.NonNull;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable {
    @NonNull
    private String character;

    @NonNull
    private Integer foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        var foodType = getFoodType();
        var r = new Random();
        System.out.println(character + " wait " + foodType + " x " + foodAmount);
        try {
            Thread.sleep(1000 * (r.nextInt(4) + 1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " got " + foodType + " x " + foodAmount);

    }
}
