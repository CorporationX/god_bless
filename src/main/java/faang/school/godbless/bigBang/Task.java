package faang.school.godbless.bigBang;

public class Task implements Runnable {
  private String name;
  private String task;

  public Task(String name, String task) {
    this.name = name;
    this.task = task;
  }

  @Override
  public void run() {
    System.out.println("Task: " + name + " started");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("Task: " + name + " was failed according to: " + e.toString());
      throw new RuntimeException(e);
    }

    System.out.println("Task: " + name + " has completed");
  }
}
