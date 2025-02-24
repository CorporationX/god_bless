package school.faang.BJS235974;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        try {
            System.out.println(character + " получает " + foodAmount + " куриных крылышек " + getFoodType());
            Thread.sleep((new Random().nextInt(5) + 1) * 1000);
            System.out.println(character + " ест " + foodAmount + " куриных крылышек");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        int index = foodTypes.length;
        return foodTypes[new Random().nextInt(index)];
    }
}
