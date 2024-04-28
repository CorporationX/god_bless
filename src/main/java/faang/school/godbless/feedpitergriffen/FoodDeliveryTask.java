package faang.school.godbless.feedpitergriffen;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Data
@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;


    @Override
    public void run() {
        String food = getFoodType();
        int randomWaitTime = getRandomWaitTime();
        System.out.printf(
                "\t\t\t%s ПОЛУЧИТ >>>> %d <<<< %s через >> %d << миллисекунд\n",
                character, foodAmount, food, randomWaitTime);
        try {
            Thread.sleep(getRandomWaitTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf(
                "\t\t\t%s ЕСТ >>>> %d <<<< %s\n",
                character, foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    private int getRandomWaitTime() {
        return 1000 * (new Random().nextInt(1, 4));
    }
}
