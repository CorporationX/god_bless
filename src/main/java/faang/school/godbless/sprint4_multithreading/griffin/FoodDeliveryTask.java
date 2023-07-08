package faang.school.godbless.sprint4_multithreading.griffin;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Random;

@AllArgsConstructor
@Data
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
        System.out.println(character + " получает " + foodAmount + " " + food);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " ест " + foodAmount + " " + food);
    }
}

