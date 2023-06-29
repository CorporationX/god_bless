package faang.school.godbless.nicePoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
  public static void main(String[] args) {
    String[] chores = {"clean room", "go with dog for a walk" + "cooking"};

    ExecutorService executor = Executors.newCachedThreadPool();

    for (String chore : chores) {
      executor.execute(new Chore(chore));
    }

    executor.shutdown();
  }
}
