package faang;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final int TASK_DURATION_IN_SECONDS = 5;

    private final String character;
    private final int foodCount;
    private final Random random;

    @SneakyThrows
    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.println(character + ": " + foodType + " в количестве " + foodCount);
        TimeUnit.SECONDS.sleep(random.nextInt(TASK_DURATION_IN_SECONDS));
        System.out.println(character + ": съест " + foodCount + " " + foodType);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}

