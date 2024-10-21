package school.faang.BJS2_35991_FeedPeterGriffin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private final static int MIN_SLEEP_TIME_SECONDS = 1;
    private final static int MAX_SLEEP_TIME_SECONDS = 5;
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        int sleepTime = ThreadLocalRandom.current().nextInt(MIN_SLEEP_TIME_SECONDS, MAX_SLEEP_TIME_SECONDS + 1) * MILLISECONDS_IN_SECOND;
        log.info("{} gets {} in amount of {}.", character, foodAmount, food);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            log.error(
                    String.format("The thread %s was interrupted while its execution!", Thread.currentThread().getName()),
                    e
            );
            throw new IllegalStateException(
                    String.format("The thread %s was interrupted while its execution!", Thread.currentThread().getName()),
                    e
            );
        }
        log.info("{} eats {} in amount of {}.", character, foodAmount, food);
    }

    private String getFoodType() {
        return FOOD_TYPES[ThreadLocalRandom.current().nextInt(FOOD_TYPES.length)];
    }
}
