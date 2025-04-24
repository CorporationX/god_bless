package faang;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int TASK_DURATION_IN_SECONDS = 5;

    private final String character;
    private final int foodCount;

    @SneakyThrows
    @Override
    public void run() {
        final FoodType foodType = getFoodType();
        final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        System.out.println(character + ": " + foodType + " в количестве " + foodCount);
        TimeUnit.SECONDS.sleep(threadLocalRandom.nextInt(TASK_DURATION_IN_SECONDS) + 1);
        System.out.println(character + ": съест " + foodCount + " " + foodType);
    }

    private FoodType getFoodType() {
        final FoodType[] foodTypes = FoodType.values();
        final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return foodTypes[threadLocalRandom.nextInt(foodTypes.length)];
    }
}

