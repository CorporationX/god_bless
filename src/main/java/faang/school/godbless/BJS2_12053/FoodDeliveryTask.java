package faang.school.godbless.BJS2_12053;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public String getFoodType() {
        String[] food = {"pizza", "burger", "hot dog", "chicken wings", "taco"};

        return food[new Random().nextInt(food.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();

        System.out.println(character + " получает " + foodType + "...");

        try {
            // 1 единица еды - 1 секунда доставки
            Thread.sleep(foodAmount * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " получил " + foodType + " в размере " + foodAmount);
    }
}
