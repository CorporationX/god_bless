package faang.school.godbless.BJS2_12028;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
  private String character;
  private int foodAmount;

  private String getFoodType() {
    String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    return foodTypes[new Random().nextInt(foodTypes.length)];
  }

  @Override public void run() {
    System.out.println(character + " получает " + foodAmount + " " + getFoodType());
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(character + " получил " + foodAmount + " " + getFoodType());
  }
}
