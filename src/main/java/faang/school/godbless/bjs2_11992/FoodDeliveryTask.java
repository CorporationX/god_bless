package faang.school.godbless.bjs2_11992;

import faang.school.godbless.ColorScheme;
import java.util.Random;

public record FoodDeliveryTask(String character, int foodAmount) implements Runnable {
  private static final String GET = " получил ";
  private static final String EATS = " ест ";
  private static final String EMPTY_VALUE = " ";
  private static final long TIME_PER_ONE_PRODUCT = 1000L;

  @Override
  public void run() {
    final String food = getFoodType();
    final String colorScheme = ColorScheme.findByID(new Random().nextInt(ColorScheme.values().length));
    System.out.println(colorScheme + character + GET + foodAmount + EMPTY_VALUE + food);
    try {
      Thread.sleep(foodAmount * TIME_PER_ONE_PRODUCT);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(colorScheme + character + EATS + foodAmount + EMPTY_VALUE + food);
  }

  private String getFoodType() {
    String[] foodTypes = {"pizza", "burger", "hot dog", "chicken wings", "taco"};
    return foodTypes[new Random().nextInt(foodTypes.length)];
  }

}
