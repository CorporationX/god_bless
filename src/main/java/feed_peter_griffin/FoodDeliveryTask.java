package feed_peter_griffin;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;


    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.printf("%s получает %d %s%n", character, foodAmount, getFoodType());
        try {
            Thread.sleep(foodAmount * 500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s ест %d %s%n", character, foodAmount, getFoodType());
    }
}
