package faang.school.godbless.bjs2_11992;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GriffinsFoodDelivery {
  private static final int POOL_SIZE = 3;
  private static final int MAX_AMOUNT_FOOD = 100;
  private static final int TIMEOUT = 30;

  public static void main(String[] args) {
    String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    for (int i = 0; i < characterNames.length; i++) {
      executorService.submit(new FoodDeliveryTask(characterNames[i], new Random().nextInt(MAX_AMOUNT_FOOD)));
    }

    executorService.shutdown();

    try {
      executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
