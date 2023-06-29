package faang.school.godbless.family;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;

    @Override
    public void run() {
        try {
            System.out.println(character + " �������� " + foodAmount + " " + getFoodType());
            Thread.sleep(foodAmount * new Random().nextInt(1-5));
            System.out.println(character + " ���� ��������");
            System.out.println(character + " ��� " + foodAmount + " " + getFoodType());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
