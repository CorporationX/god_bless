package school.faang.griffin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.function.Consumer;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "FoodDeliveryTask")
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final Random random = new Random();

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
            Thread.sleep(random.nextInt(1, 5));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("FoodDeliveryTask | Поток прерван", e.getCause());
        }
        logAction.accept("ест");
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
