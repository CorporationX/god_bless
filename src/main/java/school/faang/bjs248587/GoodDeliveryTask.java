package school.faang.bjs248587;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class GoodDeliveryTask implements Runnable {

    private static final int MAX_SLEEP_TIME = 6000;
    private static final int MIN_SLEEP_TIME = 1000;
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s receiving %d %s%n", character, foodAmount, food);
        try {
            Thread.sleep(new Random().nextInt(MAX_SLEEP_TIME) + MIN_SLEEP_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s eating %d %s%n", character, foodAmount, food);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
