package faang.school.godbless.BJS2_24002;

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
    public void run() {
        String food = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + food);
        try {
            Thread.sleep(1000 * new Random().nextInt(1,5) + 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } // idea ругалась и предложила добавить исключение, по другому не работает
        System.out.println(character + " ест " + foodAmount + " " + food);
    }
}
