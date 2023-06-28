package faang.school.godbless.griffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.SQLOutput;
import java.util.Random;

@Data
@AllArgsConstructor

public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + food);
        try {
            Thread.sleep(foodAmount* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " получил " + foodAmount + " " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
