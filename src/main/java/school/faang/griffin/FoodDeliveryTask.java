package school.faang.griffin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.RandomUtils;

import java.util.Random;
import java.util.function.Consumer;

import static school.faang.RandomUtils.RANDOM;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "FoodDeliveryTask")
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private static final int MIN_SLEEP_TIME = 1;
    private static final int MAX_SLEEP_TIME = 5;

    /**
     * Имя персонажа который получит еду
     */
    private final String character;

    /**
     * Количество еды, которое будет доставлено
     */
    private final int foodAmount;

    @Override
    public void run() {
        var foodType = getFoodType();
        Consumer<String> logAction = action -> log.info("{} {} {} {}", character, action, foodAmount, foodType);
        logAction.accept("получает");
        try {
            Thread.sleep(RANDOM.nextInt(MIN_SLEEP_TIME, MAX_SLEEP_TIME));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("FoodDeliveryTask | Поток прерван", e.getCause());
        }
        logAction.accept("ест");
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }
}
