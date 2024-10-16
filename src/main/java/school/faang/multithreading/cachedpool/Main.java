package school.faang.multithreading.cachedpool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public static final int MAX_WAITING_TIME = 5;

  public static void main(String[] args) throws InterruptedException {
    WeasleyFamily family = new WeasleyFamily();
    List<Chore> chores = new ArrayList<>();

    for (String chore : family.getChores()) {
      chores.add(new Chore(chore));
    }

    ExecutorService executor = Executors.newCachedThreadPool();

    chores.forEach(executor::execute);

    executor.shutdown();

    if (!executor.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
      executor.shutdownNow();
      if (!executor.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
        System.out.println("the pool did not terminate");
      }
    }
  }

}

