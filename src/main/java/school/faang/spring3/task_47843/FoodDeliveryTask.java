package school.faang.spring3.task_47843;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private static final int MIN_SLEEP = 1000;
    private static final int MAX_SLEEP = 5000;

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " gets " + foodAmount + " " + foodType);
        try {
            Thread.sleep(new Random().nextInt(MIN_SLEEP, MAX_SLEEP));
        } catch (InterruptedException e) {
            log.error("problem with method sleep " + e.getMessage());
        }
        System.out.println(character + " is eating " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
