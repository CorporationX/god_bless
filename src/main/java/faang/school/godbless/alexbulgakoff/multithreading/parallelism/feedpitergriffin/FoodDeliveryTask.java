package faang.school.godbless.alexbulgakoff.multithreading.parallelism.feedpitergriffin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;
    private String eat;

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
        this.eat = getFoodType();
    }

    @Override
    public void run() {
        System.out.println(character + " получает " + foodAmount + " " + eat);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(character + " ест " + foodAmount + " " + eat);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
