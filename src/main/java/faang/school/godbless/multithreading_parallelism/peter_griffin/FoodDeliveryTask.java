package faang.school.godbless.multithreading_parallelism.peter_griffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String food = getFoodType();
        System.out.println(String.format("Начинаем доставку %d %s для %s", foodAmount, food, character));
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("%s получил доставку!", character));
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
