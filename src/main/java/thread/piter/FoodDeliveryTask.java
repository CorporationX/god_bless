package thread.piter;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class FoodDeliveryTask implements Runnable {
    private final Random rand = new Random();
    private String characters;
    private int foodAmount;
    private int sleepTime = (rand.nextInt(5) + 1);
    private String foodType;

    public FoodDeliveryTask(String characters, int foodAmount) {
        this.characters = characters;
        this.foodAmount = foodAmount;
        this.foodType = getFoodType();
    }

    @Override
    public void run() {
        System.out.println(characters + " получает " + foodAmount + " " + foodType);
        System.out.println(characters + " распаковывает еду " + sleepTime + " сек");
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(characters + " ест " + foodAmount + " " + foodType);
    }

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[rand.nextInt(foodTypes.length)];
    }
}
