package faang.school.godbless.BJS2_5719;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodDeliveryTask implements Runnable {
  private String character;
  private int foodAmount;
  @Override
  public void run() {
    String food = getFoodType();
    System.out.println(character + " получил " + foodAmount + " " + food);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(character + " ест " + foodAmount + " " + food);
  }

  private String getFoodType() {
    String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    return foodTypes[new Random().nextInt(foodTypes.length)];
  }
}
