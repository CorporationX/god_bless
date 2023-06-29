package faang.school.godbless;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @SneakyThrows
    @Override
    public void run() {
        var food = getFoodType();
        System.out.printf("%s получает %d %s\n", character, foodAmount, food);
        Thread.sleep(new Random().nextInt(1000, 5000));
        System.out.printf("%s съел %d %s\n", character, foodAmount, food);

    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
