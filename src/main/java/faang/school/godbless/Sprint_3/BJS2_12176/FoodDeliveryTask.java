package faang.school.godbless.Sprint_3.BJS2_12176;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Random;

@Data
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
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);
        try {
            Thread.sleep(1000); // Подождем 1 секунду
        } catch (InterruptedException e) {
            System.out.println("Доставка была прервана");
        }
        System.out.println(character + " ест " + foodAmount + " " + foodType);
    }
}
