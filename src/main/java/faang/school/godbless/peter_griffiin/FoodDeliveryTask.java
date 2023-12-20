package faang.school.godbless.peter_griffiin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(character + " ожидает " + foodAmount + " " + getFoodType());
            try {
                Thread.sleep(new Random().nextInt(500));
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(character + " ест " + foodAmount + " " + getFoodType());
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
