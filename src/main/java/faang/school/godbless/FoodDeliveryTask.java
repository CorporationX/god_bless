package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Data
@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();
        log.info(character + " получает " + foodAmount + " " + food);
        waitRandom();
        log.info(character + " ест " + foodAmount + " " + food);
    }

    private void waitRandom() {
        try {
            Thread.sleep(new Random().nextInt(character.length()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
