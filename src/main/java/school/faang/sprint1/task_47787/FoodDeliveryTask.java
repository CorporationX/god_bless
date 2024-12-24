package school.faang.sprint1.task_47787;

import lombok.Getter;

import java.util.Random;

@Getter
public class FoodDeliveryTask implements Runnable {
    private String character;
    private int foodAmount;
    private Random random = new Random();

    public FoodDeliveryTask(String character, int foodAmount) {
        this.character = character;
        this.foodAmount = foodAmount;
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        String food = getFoodType();
        try {
            System.out.println(character + " получает " + foodAmount + " " + food);
            Thread.sleep(random.nextInt(5000) + 1000);
            System.out.println(character + " получил" + foodAmount + " " + food);
        } catch (InterruptedException e) {
            System.out.println(character + " не получил " + food + "т.к доставка прервалась");
        }
    }
}
