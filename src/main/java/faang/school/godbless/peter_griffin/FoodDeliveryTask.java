package faang.school.godbless.peter_griffin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
@Data
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;
    private final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wing", "taco"};


    private String getFoodType() {
        return FOOD_TYPES[new Random().nextInt(FOOD_TYPES.length)];
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(character + " gets " + foodAmount + " " + getFoodType() + "s");
        Thread.sleep(new Random().nextInt(5) * 1000);
    }
}
