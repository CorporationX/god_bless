package faang.school.godbless.eat_Piter_Griffin;

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
        try {
            String foodType = getFoodType();

            System.out.println(this.getCharacter() +
                    " получает " + this.getFoodAmount() +
                    " " + foodType);

            Thread.sleep(new Random().nextInt(5 * 1000));

            System.out.println(this.getCharacter() +
                    " ест " + this.getFoodAmount() +
                    " " + foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
