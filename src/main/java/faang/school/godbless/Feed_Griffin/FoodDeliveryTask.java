package faang.school.godbless.Feed_Griffin;

import lombok.Getter;

import java.util.Random;

@Getter
public class FoodDeliveryTask implements Runnable {

    private final String character;
    private final int foodAmount;

    public FoodDeliveryTask(String character, int foodAmount) {
        if (character.isBlank() || foodAmount < 0) throw new IllegalArgumentException();
        else {
            this.character = character;
            this.foodAmount = foodAmount;
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = this.getFoodType();
        for (int i=1; i<=foodAmount; i++) {
            System.out.println(food + " : portion number " + i + " was sent");
            System.out.println(this.character + " received portion number " + i);
        }
        System.out.println(this.character + " received all the  food!");
    }

}
