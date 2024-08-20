package faang.school.godbless.griffiny;

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
        System.out.println(character + " получает " + foodAmount + " " + getFoodType());
        System.out.println("Ждем " + foodAmount + " сек пока " + character + " получит доставку");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " получил доставку");
        System.out.println(character + " ест " + foodAmount + " " + getFoodType());
    }
}
