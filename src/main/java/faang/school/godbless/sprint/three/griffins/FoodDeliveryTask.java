package faang.school.godbless.sprint.three.griffins;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s get %d %s%n", this.character, this.foodAmount, foodType);
        int deliveryTime = Constants.DELIVERY_TIME[new Random().nextInt(Constants.DELIVERY_TIME.length)];

        System.out.printf("%s waiting delivery for %d seconds%n",
                this.character, deliveryTime / Constants.SECOND_IN_MILLISECOND);
        try {
            Thread.sleep(deliveryTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s eats %d %s%n", this.character, this.foodAmount, foodType);
        try {
            Thread.sleep(this.foodAmount * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
