package school.faang.bjs2_81051;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.Random;

@Slf4j
@Getter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final Random random = new Random();

    private String character;
    private int amountFood;

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType type = getFoodType();
        log.info("{} получает {} {}", character, amountFood, type);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Мой поток был прерван");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("{} ест {} {}", character, amountFood, type);
    }

}
