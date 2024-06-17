package faang.school.godbless.BJS2_12192;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
  public static void main(String[] args) {
    List<Chore> chores = List.of(new Chore("chore1"),
      new Chore("chore2"),
      new Chore("chore3"),
      new Chore("chore4"),
      new Chore("chore5"));
    ExecutorService executor = Executors.newCachedThreadPool();
    for (Chore chore : chores) {
      executor.execute(chore);
    }
    executor.shutdown();
  }
}
