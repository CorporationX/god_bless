package faang.school.godbless.parallelism.familyGuy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoolDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;


    @Override
    public void run() {
        String foodType = getFoodType();

        log.info(foodAmount + " portions of " + foodType + " was sent to " + character);

        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            log.error("Delivery wasn't accomplished. Something went wrong.", e);
            return;
        }

        log.info(character + " received " + foodAmount + " portions of " + foodType);
    }

    public static String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
