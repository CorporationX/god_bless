package faang.school.godbless.feedpetergriffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private int waitingTime;

    @Override
    public void run() {
        String foodtype = getFoodType();
        System.out.println("От " + character + " получен заказ на " + foodtype + " " + foodAmount + "шт");
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Доставка завершена " + character + " было получено " + foodtype + " " + foodAmount + "шт");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
