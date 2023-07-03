package faang.school.godbless.Sprint4.PitterGrifin;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("%s получит - %d %s \n", character, foodAmount, getFoodType());
        Thread.sleep(100);
        System.out.printf("%s ест - %d %s \n", character, foodAmount, getFoodType());
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
