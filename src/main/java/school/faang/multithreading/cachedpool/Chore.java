package school.faang.multithreading.cachedpool;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {

  private String chore;

  @SneakyThrows
  @Override
  public void run() {
    System.out.println("Executing " + chore.toUpperCase() + " with " + Thread.currentThread().getName());
    Thread.sleep(3000);
  }
}
