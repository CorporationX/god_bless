package faang.school.godbless.griffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.SQLOutput;
import java.util.Random;

@Data
@AllArgsConstructor

public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println();
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
