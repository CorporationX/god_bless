package faang.school.godbless.BJS2_1091;

import lombok.Data;

import java.util.Random;

@Data
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.printf("%s is getting %s of %s \n"
                , this.character, this.foodAmount, this.getFoodType());

        try {
            Thread.sleep(this.foodAmount * 100L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("%s is eating %s of %s \n"
                , this.character, this.foodAmount, this.getFoodType());
    }
}