package faang.school.godbless.nicePoor;

public class Chore implements Runnable {
  private String taskName;

  public Chore(String taskName) {
    this.taskName = taskName;
  }

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    System.out.println("Thread called:" + threadName + " running task: " + taskName);

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Thread called:" + threadName + " completed task: " + taskName);
  }
}
