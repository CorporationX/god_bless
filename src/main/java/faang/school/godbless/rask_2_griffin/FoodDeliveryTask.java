package faang.school.godbless.rask_2_griffin;

import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable{

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();

        try {
            System.out.printf("%s ждёт доставку.\n", character);
            Thread.sleep(foodAmount * 1000L);

            System.out.printf("%s получает %d %s.\n", character, foodAmount, food);
            Thread.sleep(new Random().nextInt(1, 3) * 1000L);

            System.out.printf("%s ест %d %s.\n", character, foodAmount, food);
            Thread.sleep((long)(Math.ceil(foodAmount / 2.0)) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
