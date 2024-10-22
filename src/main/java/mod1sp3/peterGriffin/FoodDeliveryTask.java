package mod1sp3.peterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);
        int randomDelay = new Random().nextInt(1,5) * 1000;
        try {
            Thread.sleep(randomDelay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        int randomFoodType = new Random().nextInt(foodTypes.length);
        return foodTypes[randomFoodType];
    }
}
