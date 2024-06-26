package faang.school.godbless.sprint3.deliverFoodToGriffin;

import lombok.RequiredArgsConstructor;

import java.util.Random;

public class FoodDeliveryTask implements Runnable{

    private String character;
    private Integer foodAmount;

    public FoodDeliveryTask(String character, Integer foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        try {
            String foodType = getFoodType();
            System.out.println(character + " is getting " + foodAmount + " " + foodType);
            Thread.sleep(new Random().nextInt(5) * 1000);
            System.out.println(character + " is eating " + foodAmount + " " + foodType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
