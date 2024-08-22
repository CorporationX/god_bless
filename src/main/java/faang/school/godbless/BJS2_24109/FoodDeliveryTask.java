package faang.school.godbless.BJS2_24109;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    @Override
    public void run() {
        System.out.println(character + " got " + foodAmount + " " + getFoodType() +
                ((foodAmount > 1) ? "s" : ""));
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
