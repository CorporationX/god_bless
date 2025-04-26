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
    private static final int TIME_COOKING = 100;

    @Override
    public void run() {
        String foodName = getFoodType().name();
        try {
            System.out.printf("%s заказал %s в количестве %d\n", character, foodName, foodAmount);

            Thread.sleep(random.nextInt(foodAmount * TIME_COOKING));

            System.out.printf("%s есть %s в количестве %d \n", character, foodName, foodAmount);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Нарушение работы потока");
        }

    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
