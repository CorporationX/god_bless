package school.faang.feed_piter_griffin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final static int ONE_SECOND_SLEEP_TIME = 1000;
    private final static int FOUR_SECOND_SLEEP_TIME = 4000;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        int randomFoodTypeIndex = new Random().nextInt(foodTypes.length);
        return foodTypes[randomFoodTypeIndex];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " is getting " + foodAmount + " " + foodType);
        int sleepTime = ONE_SECOND_SLEEP_TIME + new Random().nextInt(FOUR_SECOND_SLEEP_TIME);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error("Exception in threads connected to sleep() method", e);
            e.printStackTrace();
        }
        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }
}