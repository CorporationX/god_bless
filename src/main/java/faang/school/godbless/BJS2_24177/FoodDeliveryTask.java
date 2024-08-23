package faang.school.godbless.BJS2_24177;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;


    @Override
    public void run() {
        int deliveryTimeSecond = 5;
        String eat = getFoodType();
        System.out.format("%s получает %d %s%n", character, foodAmount, eat);
        System.out.println("Курьер в пути. Время доставки: " + deliveryTimeSecond);
        try {
            TimeUnit.SECONDS.sleep(deliveryTimeSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(character + " получил заказ");
        System.out.format("%s объелся %s", character, eat);
        System.out.println();
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
