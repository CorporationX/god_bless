package faang.school.godbless.BJS2_5719;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
  private static final int NUM_THREADS = 3;
  private static final Random RND_FOOD_AMOUNT = new Random();

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

    for (String characterName : characterNames) {
      executorService.execute(new FoodDeliveryTask(characterName, RND_FOOD_AMOUNT.nextInt(1, 20)));
    }
    executorService.shutdown();

    try {
      while (!executorService.awaitTermination(30, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
