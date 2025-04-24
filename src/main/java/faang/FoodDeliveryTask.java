package faang;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int TASK_DURATION_IN_SECONDS = 5;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private final String character;
    private final int foodCount;

    @SneakyThrows
    @Override
    public void run() {
        final FoodType foodType = getFoodType();
        System.out.println(character + ": " + foodType + " в количестве " + foodCount);
        TimeUnit.SECONDS.sleep(RANDOM.nextInt(TASK_DURATION_IN_SECONDS) + 1);
        System.out.println(character + ": съест " + foodCount + " " + foodType);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }
}

