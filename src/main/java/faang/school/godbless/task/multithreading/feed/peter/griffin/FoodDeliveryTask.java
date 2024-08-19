package faang.school.godbless.task.multithreading.feed.peter.griffin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int SECOND_LIMIT_HIGH = 5;
    private static final int SECOND_LIMIT_LOW = 1;

    private final Random random = new Random();
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        try {
            String food = getFoodType();
            System.out.printf("\n%s ordered %s %s", character, foodAmount, food);
            Thread.sleep(getRandomMillisecond());
            System.out.printf("\n%s receives %s %s", character, foodAmount, food);
            Thread.sleep(getRandomMillisecond());
            System.out.printf("\n%s eating %s %s", character, foodAmount, food);
            Thread.sleep(getRandomMillisecond());
            System.out.printf("\n%s ate.", character);
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizzas", "burgers", "hot dogs", "chicken wings", "tacos"};
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    private int getRandomMillisecond() {
        return (random.nextInt(SECOND_LIMIT_HIGH - SECOND_LIMIT_LOW) + SECOND_LIMIT_LOW) * 1000;
    }
}
