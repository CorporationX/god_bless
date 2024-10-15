package school.faang.multithreading.cachedpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    WeasleyFamily family = new WeasleyFamily();
    List<Chore> chores = new ArrayList<>();

    for (String chore : family.getChores()) {
      chores.add(new Chore(chore));
    }

    ExecutorService executor = Executors.newCachedThreadPool();

    chores.forEach(executor::execute);

    executor.shutdown();

    boolean done = true;
    while (!executor.isTerminated()) {
      done = executor.awaitTermination(1, TimeUnit.SECONDS);
      System.out.println("tasks have been completed: " + done);
    }
    System.out.println("tasks completed: " + done);
    executor.shutdownNow();
  }

}
