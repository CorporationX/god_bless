package school.faang.bjs2_91044;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public record FoodDeliveryTask(String characterName, int foodAmount) implements Runnable {
    private static final Random RANDOM = new Random();
    private static final int FASTEST_DELIVERY_TIME = 1;
    private static final int LATEST_DELIVERY_TIME = 5;

    public FoodType getRandomFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[RANDOM.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        try {
            log.info("Доставляем {}x{} персонажу {}...", getRandomFoodType(), foodAmount, characterName);
            System.out.printf("Доставляем %sx%d персонажу %s...\n", getRandomFoodType(), foodAmount, characterName);
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(FASTEST_DELIVERY_TIME, LATEST_DELIVERY_TIME + 1));
            System.out.printf("Персонаж %s получил еду!\n", characterName);
        } catch (InterruptedException e) {
            System.out.println("Доставка еды отменена! Курьер остановлен.");
            Thread.currentThread().interrupt();
        }
    }
}
