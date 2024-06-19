package faang.school.godbless.module1.sprint3.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;


    @Override
    public void run() {
        String eat = getFoodType();
        System.out.println("Delivery started " + character + " " + foodAmount + " " + eat);
    }

    private static String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
