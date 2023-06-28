package faang.school.godbless.griffins;

import java.util.Random;

public class FoodDeliveryTask implements Runnable {
  private static String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
  private String character;
  private int foodAmount;

  public FoodDeliveryTask(String character, int foodAmount) {
    this.character = character;
    this.foodAmount = foodAmount;
  }

  private String getFoodType() {
    return foodTypes[new Random().nextInt(foodTypes.length)];
  }

  @Override
  public void run() {
    String foodType = getFoodType();
    System.out.printf(foodAmount + " " + foodType + " on the way to: " + character + "\n");

    try {
      Thread.sleep(new Random().nextInt(5 * 1000));
    } catch (InterruptedException e) {
      System.out.printf(e.toString());
    }

    System.out.printf(foodAmount + " " + foodType + " was delivered to " + character + "\n");
  }
}
