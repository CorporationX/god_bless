package faang.school.godbless.BJS2_24177;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;
    static final int DELIVERY_TIME_SECOND = 5;

    @Override
    public void run() {
        String eat = getFoodType();
        System.out.format("%s получает %d %s%n", character, foodAmount, eat);
        System.out.println("Курьер в пути. Время доставки: " + DELIVERY_TIME_SECOND);
        try {
            TimeUnit.SECONDS.sleep(DELIVERY_TIME_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(character + " получил заказ");
        System.out.format("%s объелся %s \n", character, eat);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
