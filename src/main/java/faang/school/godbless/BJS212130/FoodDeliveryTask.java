package faang.school.godbless.BJS212130;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final long MIN_LATENCY = 1000;
    private static final long MAX_LATENCY = 5001;
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(getFoodAmount() + " of " + food + " has been sent to " + getCharacter());
        try {
            Thread.sleep(new Random().nextLong(MIN_LATENCY, MAX_LATENCY));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getCharacter() + " eats " + getFoodAmount() + " of " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
