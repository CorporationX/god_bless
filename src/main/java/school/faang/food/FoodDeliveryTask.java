package school.faang.food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    @Override
    public void run() {
        String foodName = getFoodType().name();
        try {
            System.out.println(character + " заказал " + foodName + " в количестве " + foodAmount);

            Thread.sleep(random.nextInt(foodAmount * 1000));

            System.out.println(character + " ест " + foodName + " в количестве " + foodAmount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
