package faang.school.godbless.BJS2_5528;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable{
    private String character;

    @Override
    public void run() {
        feedCharacter();
    }

    @SneakyThrows
    private void feedCharacter() {
        String foodType = getFoodType();
        int foodAmount = getFoodCount();

        System.out.println(getCharacter() + " получает " + foodAmount + " " + foodType);
        System.out.println("Подождите, пока " + getCharacter() + " получит доставку");
        Thread.sleep(1000);
        System.out.println(getCharacter() + " ест " + foodAmount + " " + foodType + "\n");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    private int getFoodCount() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
