package faang.school.godbless.BJS2_24020;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private static final String[] FOOD_TYPES = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    private static Random random = new Random();

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.printf("Кому: %s, Что: %s, Сколько: %d%n", character, food, foodAmount);

        try {
            Thread.sleep(random.nextLong(1000L, 5000L));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Доставка для %s выполненна!%n", character);
    }

    private String getFoodType() {
        return FOOD_TYPES[random.nextInt(FOOD_TYPES.length)];
    }
}
