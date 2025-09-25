package school.faang.bjs2_91046;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    @Override
    public void run() {
        String foodType = getFoodType().name();
        System.out.println(Thread.currentThread()
                .getName() + " is currently delivering: " + foodType + " for " + character);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " has delivered: " + foodType + " for " + character);
    }

    private final Random random = new Random();

    private FoodType getFoodType() {
        FoodType[] foodTypes = FoodType.values();
        return foodTypes[random.nextInt(foodTypes.length)];
    }
}
