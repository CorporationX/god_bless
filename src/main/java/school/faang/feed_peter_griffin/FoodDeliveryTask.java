package school.faang.feed_peter_griffin;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        System.out.println(Thread.currentThread().getName() + ": " + character + " заказывает " + foodAmount +
                " " + foodType.toString().toLowerCase().replace("_", " ") + ".");
        try {
            int deliveryTime = (int) (Math.random() * 4000) + 1000;
            Thread.sleep(deliveryTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + "Доставка для: " + character +
                    "была прервана");
            return;
        }
        System.out.println(Thread.currentThread().getName() + ": " + character + " ест и наслаждается: " +
                foodAmount + " " + foodType.toString().toLowerCase().replace("_", " ") + ".");

    }
}