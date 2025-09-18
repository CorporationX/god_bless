package school.faang.bjs2_91100;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final Random random = new Random();
    private String character;
    private int foodAmount;

    public FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        log.info("{} - доставщик, {} - Получает {} в количестве {}",
                Thread.currentThread().getName(), character, getFoodType(), foodAmount);
        try {
            Thread.sleep(random.nextInt(1000, 5000));
        } catch (InterruptedException e) {
            log.info("Exception with Thread Sleep");
        }
    }
}
