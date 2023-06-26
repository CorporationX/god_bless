package faang.school.godbless.kxnvg.griffins;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @SneakyThrows
    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " is waiting " + foodAmount + " " + foodType + "s");

        int waitTime = new Random().nextInt(5) * 1000 + 1;
        Thread.sleep(waitTime);

        System.out.println(character + " is eating " + foodAmount + " " + foodType + "s");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wing", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
