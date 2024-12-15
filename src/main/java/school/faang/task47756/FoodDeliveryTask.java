package school.faang.task47756;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(FoodDeliveryTask.class);

    private static final int TIME_SLEEP = 10;

    private final String character;
    private final int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();

        System.out.printf("%s receives %d %s%n", character, foodAmount, food);

        try {
            TimeUnit.SECONDS.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            return;
        }

        System.out.printf("%s eat %d %s%n", character, foodAmount, food);
    }
}
