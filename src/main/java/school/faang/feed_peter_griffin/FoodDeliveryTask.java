package school.faang.feed_peter_griffin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Getter
@Slf4j
class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        String foodDescription = foodType.toString().toLowerCase().replace("_", " ");
        log.info("{}: {} заказывает {} {}.", Thread.currentThread().getName(), character, foodAmount, foodDescription);
        try {
            int deliveryTime = random.nextInt(4000) + 1000;
            Thread.sleep(deliveryTime);
        } catch (InterruptedException e) {
            log.warn("Доставка для {} была прервана в потоке {}", character, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return;
        }
        log.info("{}: {} ест и наслаждается: {} {}.", Thread.currentThread().getName(),
                character, foodAmount, foodDescription);
    }
}