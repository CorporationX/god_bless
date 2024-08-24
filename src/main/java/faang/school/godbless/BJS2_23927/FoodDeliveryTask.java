package faang.school.godbless.BJS2_23927;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@AllArgsConstructor
@Slf4j
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        try {
            String foodType = this.getFoodType();
           log.info("{} gets {} {}", this.character, this.foodAmount, foodType);
            Thread.sleep(foodAmount + 1000);
            log.info("{} is eating {} {}", this.character, this.foodAmount, foodType);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread wa interrupted: {}", e.getMessage());
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
