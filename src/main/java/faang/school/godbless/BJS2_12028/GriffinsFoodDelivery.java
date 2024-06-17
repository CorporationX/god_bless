package faang.school.godbless.BJS2_12028;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
  private final static int THREADS = 3;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    for (String name : characterNames) {
      executor.execute(new FoodDeliveryTask(name, new Random().nextInt(100)));
    }
    executor.shutdown();
  }
}
