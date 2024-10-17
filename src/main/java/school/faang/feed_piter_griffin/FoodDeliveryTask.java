package school.faang.feed_piter_griffin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " is getting " + foodAmount + " " + foodType);
        int sleepTime = 1000 + new Random().nextInt(4000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("Exception in threads connected to sleep() method", e);
            e.printStackTrace();
        }
        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }
}