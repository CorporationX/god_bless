package faang.school.godbless.BJS2_12149;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();
        String info = character + " %s " + foodAmount + " " + food;
        try {
            System.out.println(String.format(info, "получает"));
            Thread.sleep(new Random().nextInt(1, 5));
            System.out.println(String.format(info, "ест"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
