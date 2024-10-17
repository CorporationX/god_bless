package dima.evseenko.delivery;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        String randomFood = getRandomFoodType();
        System.out.printf("Началась доставка %s - %s шт для %s%n", randomFood, foodAmount, character);
        try {
            Thread.sleep(new Random().nextInt(5000 - 1000) + 1000);
            System.out.printf("Доставка %s - %s шт для %s успешно завершена%n", randomFood, foodAmount, character);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка доставки %s - %s для %s".formatted(randomFood, foodAmount, character), e);
        }
    }

    private String getRandomFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
