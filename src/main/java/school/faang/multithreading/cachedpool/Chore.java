package school.faang.multithreading.cachedpool;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

  private String chore;


  @Override
  public void run() {
    System.out.println(
        "Executing " + chore.toUpperCase() + " with " + Thread.currentThread().getName());
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println(Thread.currentThread().getName() + " .. interrupted");
    }
  }
}
