package feed_peter_griffin;

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
        String foodTypes = getFoodType();
        System.out.println(String.format(" %s ждёт дсотавку %d %s", character, foodAmount, foodTypes));
        Thread.sleep(1000L);
        System.out.println(String.format(" %s жадно съел %d %s", character, foodAmount, foodTypes));
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}