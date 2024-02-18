package faang.school.godbless.feedpetergriffin2759;

import lombok.Getter;

import java.util.Random;

@Getter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    @Override
    public void run() {
        String foodType = getFoodType();
        System.out.printf("%s ordered %d %ss,waiting for delivery%n", this.getCharacter(), this.getFoodAmount(), foodType);
        try {
            Thread.sleep(new Random().nextLong(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s got %ss and happily eating%n", this.getCharacter(), foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wing", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
