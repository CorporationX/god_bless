package faang.school.godbless.griffins;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@Getter
@AllArgsConstructor
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

        try {
            Thread.sleep(1250);
            IntStream.range(1, foodAmount + 1)
                    .boxed()
                    .peek(i -> log.info("#" + i + " " + food + " доставлено"))
                    .toList();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(character + " все получил и съел " + food + " в количестве: " + foodAmount);
    }
}
