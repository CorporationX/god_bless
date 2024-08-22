package faang.school.godbless.FeedPeterGriffin;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        int deliveryTime = (new Random().nextInt(5) + 1) * 1000;
        System.out.println(character + " ожидает доставки: " + foodAmount + " " + getFoodType());
        try {
            Thread.sleep(deliveryTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(character + " получает доставку: " + foodAmount + " " + getFoodType() + " и приступает к трапезе");
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
