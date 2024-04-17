package faang.school.godbless.module.third.parallelism.peter;

import java.util.Random;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    
    @Override
    public void run() {
        System.out.printf("%s заказал %s %s \n", character, foodAmount, getFoodType());
        try {
            Thread.sleep(new Random().nextInt(100, 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("%s получил доставку \n", character);
    }
    
    private String getFoodType() {
        String[] foodTypes = { "pizza", "burger", "hot dog", "chicken wings", "taco" };
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
