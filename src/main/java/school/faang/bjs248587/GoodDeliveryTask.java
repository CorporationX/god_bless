package school.faang.bjs248587;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class GoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("%s receiving %d %s%n", character, foodAmount, food);
        try {
            Thread.sleep(new Random().nextInt(6000) + 1000);
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
