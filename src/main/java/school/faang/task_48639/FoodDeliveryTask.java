package school.faang.task_48639;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@ToString
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        Random random = new Random();
        String randomFood = getFoodType();
        log.info("{} got {} {}", character, foodAmount, randomFood);
        try {
            Thread.sleep(random.nextInt(1, 5) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("{} eat {} {}", character, foodAmount, randomFood);
    }
}
