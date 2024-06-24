package faang.school.godbless.peter.griffin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDeliveryTask implements Runnable{

    private String character;
    private int foodAmount;

    private String getFoodType() {
        String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    @Override
    public void run() {
        System.out.println(String.format("%s gets %d %s", getCharacter(), getFoodAmount(), getFoodType()));
        int sleepTime = new Random().nextInt(5) + 1;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка реализации: \"TimeUnit.SECONDS.sleep(sleepTime);\"");
        }
        System.out.println(String.format("%s is eating %d %s", getCharacter(), getFoodAmount(), getFoodType()));
    }
}
