package Sprint_3.BJS2_36081;
import lombok.Getter;
import lombok.Setter;
import java.util.Random;

@Getter
@Setter
public class FoodDeliveryTask implements Runnable {

    private String character;
    private int foodAmount;

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
        String foodType = getFoodType();
        System.out.println(character + " получает " + foodAmount + " " + foodType);
        try {
            int delay = new Random().nextInt(5) + 1;
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            System.out.println(character + " была прервана");
        }
        System.out.println(character + " ест " + foodType);
    }


}
