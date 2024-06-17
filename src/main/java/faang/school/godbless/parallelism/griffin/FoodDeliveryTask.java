package faang.school.godbless.parallelism.griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s оформил заказ на %s x%d, ожидаем доставку\n",
                character, foodType, foodAmount);

        try {
            Thread.sleep(new Random().nextInt(1, 5 + 1) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s получил x%d %s\n", character, foodAmount, foodType);

    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
