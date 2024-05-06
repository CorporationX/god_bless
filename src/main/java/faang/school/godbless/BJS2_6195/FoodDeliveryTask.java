package faang.school.godbless.BJS2_6195;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        String foodType = getTypeFood();
        System.out.println(character + " получил " + foodAmount + " " + foodType);
        try {
            Thread.sleep(foodAmount * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }

    private String getTypeFood() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
