package faang.school.godbless.eat_Piter_Griffin;

import lombok.Data;

import java.security.SecureRandom;

@Data
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    public static final SecureRandom RANDOM_FOOD_TYPE = new SecureRandom();

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[RANDOM_FOOD_TYPE.nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        try {
            String foodType = getFoodType();

            System.out.println(this.getCharacter() +
                    " получает " + this.getFoodAmount() +
                    " " + foodType);

            Thread.sleep(RANDOM_FOOD_TYPE.nextInt(5 * 1000));

            System.out.println(this.getCharacter() +
                    " ест " + this.getFoodAmount() +
                    " " + foodType);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
