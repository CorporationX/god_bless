package faang.school.godbless.feed_peter_griffin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Map;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class FoodDeliveryTask implements Runnable {
    private String Character;
    private int foodAmount;
    @SneakyThrows
    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(Character + " ordered " + foodAmount + " " + food);
        var waitTime = (long)(Math.random()*5000 + 1000);
        Thread.sleep(waitTime);
        System.out.println(Character + " eats " + foodAmount + " " + food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
