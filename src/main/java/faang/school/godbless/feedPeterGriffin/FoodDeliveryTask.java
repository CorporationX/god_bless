package faang.school.godbless.feedPeterGriffin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        System.out.println("Started delivery of "+getFoodType()+" in amount of "+foodAmount+" to "+character+".");
        long randomTime = new Random().nextInt((5000-1000 + 1) + 1000);
        try {
            Thread.sleep(randomTime);
            System.out.println(character+" has received the delivery.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
