package faang.school.godbless.BJS25686;

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

        try {
            Thread.sleep(new Random().nextInt(5000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
