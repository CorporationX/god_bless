package school.faang.bjs2_91050;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.Random;

@Slf4j
@Getter
public class FoodDeliveryTask implements Runnable {
    private final String character;
    private final int foodAmount;

    private static final Random RANDOM = new Random();
    private static final int DELIVERY_TIME = RANDOM.nextInt(1, 5);

    public FoodDeliveryTask(String character) {
        this.character = character;
        this.foodAmount = RANDOM.nextInt(1, 50);
    }

    public FoodType getFoodType() {
        FoodType[] randomFoodType = FoodType.values();
        return randomFoodType[RANDOM.nextInt(randomFoodType.length)];
    }

    @Override
    public void run() {
        FoodType randomFoodType = getFoodType();
        log.info("Машина начала свой путь. Получатель: {}, Продукт: {}, Количество: {}",
                character, getFoodType().getFoodTypeFormatted(), foodAmount);
        try {
            Thread.sleep(DELIVERY_TIME);
            System.out.printf("Машина %s: Успешно доставили еду! %s получил %d штук %s\n",
                    Thread.currentThread().getName(), character, foodAmount, randomFoodType.getFoodTypeFormatted());
        } catch (InterruptedException e) {
            System.out.printf("Машина %s: Моя доставка была прервана\n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}