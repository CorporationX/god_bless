package faang.school.godbless.peter.griffin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(character + " получает " + foodAmount + " " + getFoodType());
        Thread.sleep(foodAmount * 1000L);
        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }
}
