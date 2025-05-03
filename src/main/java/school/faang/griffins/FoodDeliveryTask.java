package school.faang.griffins;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;
    private final Random random = new Random();
    private static final int MILLISECONDS_IN_SECOND = 1000;
    private static final int THREADS_AMOUNT = 5;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        FoodType foodType = getFoodType();
        log.info("{} получает {}  {} ов", character, foodAmount, foodType.toString().toLowerCase());

        try {
            int delay = MILLISECONDS_IN_SECOND * (1 + random.nextInt(THREADS_AMOUNT));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Доставка была прервана: " + e.getMessage());
        }
        log.info("{} ест {} {} ов", character, foodAmount, foodType.toString().toLowerCase());
    }
}