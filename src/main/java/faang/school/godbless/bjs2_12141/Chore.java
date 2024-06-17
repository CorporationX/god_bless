package faang.school.godbless.bjs2_12141;

public record Chore(String chore) implements Runnable {
  private static final String TASK_IN_PROGRESS = " Выполняемое задание: ";

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + TASK_IN_PROGRESS + chore);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
