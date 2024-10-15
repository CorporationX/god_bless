package school.faang.WeasleyFamily;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
  public static void main(String[] args) throws InterruptedException {
    List<Chore> chores = new ArrayList<>();

    chores.add(new Chore("помыть посуду"));
    chores.add(new Chore("подмести пол"));
    chores.add(new Chore("приготовить ужин"));

    ExecutorService executorService = Executors.newCachedThreadPool();

    for(Chore chore : chores) {
      executorService.submit(chore);
    }

    executorService.shutdown();
    if(!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
      System.out.println("ожидание выполнения всех обязанностей истекло");
      executorService.shutdownNow();
      System.out.println("обязанности завершенны принудительно");
    }else {
      System.out.println("все обязанности выполены");
    }
  }
}
