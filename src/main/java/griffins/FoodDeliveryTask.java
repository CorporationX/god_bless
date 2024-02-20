package griffins;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "chicken wings", "hot dog", "salad", "burrito"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.println(character + " заказал " + foodAmount + " " + foodType);
        try {
            System.out.println(character + " ждёт доставку" + " " + foodType);
            Thread.sleep(new Random().nextInt(1, 6));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }
}
