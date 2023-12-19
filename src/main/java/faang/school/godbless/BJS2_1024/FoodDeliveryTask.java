package faang.school.godbless.BJS2_1024;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
    @Override
    public void run() {
        System.out.println(character+" gets "+foodAmount+" "+getFoodType());
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException("Delay in delivery");
        }
        System.out.println(character+" is eating "+foodAmount+" "+getFoodType());
    }


}
