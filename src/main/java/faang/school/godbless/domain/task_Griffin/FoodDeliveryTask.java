package faang.school.godbless.domain.task_Griffin;

import java.util.Date;
import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {

    public void run() {
        var foodType = getFoodType();
        var deliveryTime = new Random().nextInt(1000, 10000);

        System.out.println(character + " получает " + foodAmount + " " + foodType);

        try {
            System.out.println(character + " -> Начало доставки: " + new Date(System.currentTimeMillis()));
            Thread.sleep(deliveryTime);
            System.out.println(character + " -> Время доставки: " + new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}

