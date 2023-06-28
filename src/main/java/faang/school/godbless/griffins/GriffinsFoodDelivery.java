package faang.school.godbless.griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
  private static final int THREADS_COUNT = 3;
  private static final int ORDERED_LIMIT = 100;
  private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);

    Random random = new Random();
    for (int i = 0; i < THREADS_COUNT; i++) {
      service.execute(new FoodDeliveryTask(CHARACTER_NAMES[random.nextInt(CHARACTER_NAMES.length)],
          random.nextInt(ORDERED_LIMIT)));
    }
    service.shutdown();
  }
}
