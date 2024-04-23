package faang.school.godbless.griffins;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(character + " get " + foodAmount + " " + getFoodType());
        Thread.sleep(1000);
        System.out.println(character + " eat " + foodAmount + " " + getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}