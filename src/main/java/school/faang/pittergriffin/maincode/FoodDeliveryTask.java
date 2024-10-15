package school.faang.pittergriffin.maincode;


import lombok.AllArgsConstructor;

import java.util.Random;


public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    public void run() {
        String food = getFoodType();
        try {
            System.out.println(character + " получает " + foodAmount + " " + food);

            Thread.sleep(random.nextInt(5000) + 1000);

            System.out.println(character + " ест "+ foodAmount + " " + food);
        } catch (InterruptedException e) {
            System.out.println(character + " не смог получить " + food + " из-за прерывания.");
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
