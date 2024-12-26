package school.faang.task_48639;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@ToString
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private static final int THREAD_SLEEP_TIME = 1000;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String randomFood = getFoodType();
        log.info("{} got {} {}", character, foodAmount, randomFood);
        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.info("Unexpected interrupt: " + e);
        }
        log.info("{} eat {} {}", character, foodAmount, randomFood);
    }
}
