package faang.school.godbless.BJS2_5528;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        feedCharacter();
    }

    private void feedCharacter() {
        String foodType = getFoodType();

        System.out.println(getCharacter() + " получает " + getFoodAmount() + " " + foodType);
        System.out.println("Подождите, пока " + getCharacter() + " получит доставку");

        try {
            Thread.sleep(getFoodAmount() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getCharacter() + " ест " + getFoodAmount() + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
