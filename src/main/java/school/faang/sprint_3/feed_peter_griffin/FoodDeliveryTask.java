package school.faang.sprint_3.feed_peter_griffin;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private final Random random = new Random();


    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} getting {} {}", character, foodAmount, foodType);
        try {
            Thread.sleep(random.nextInt(4000) + 1000);
        } catch (InterruptedException e) {
            log.error("Delivery interrupted" + e.getMessage());
        }
        log.info("{} eating {} {}", character, foodAmount, foodType);
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
