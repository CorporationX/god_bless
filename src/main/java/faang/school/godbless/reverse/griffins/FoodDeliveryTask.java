package faang.school.godbless.reverse.griffins;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable{
    private String character;

    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run(){
        String food = getFoodType();
        System.out.println(character + " get " + foodAmount + " " + food);
        try {
            Thread.sleep(1000 * (new Random().nextInt(6)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " eat " + foodAmount + " " + food);
    }
}
