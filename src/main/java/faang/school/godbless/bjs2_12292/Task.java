package faang.school.godbless.bjs2_12292;

public record Task(String name, String task, long time) implements Runnable {

  private static final String BEGIN_WORK_SCIENCE_PROJECT = " %s начинает работу над научным проектом : %s";
  private static final String END_WORK_SCIENCE = " %s закончил работу: %s";
  private static final String SCIENCE_ERROR = "Произошла ошибка %s при работе над нацчным проектом!";

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() +
        String.format(BEGIN_WORK_SCIENCE_PROJECT, this.name, this.task));
    try {
      Thread.sleep(this.time);
    } catch (InterruptedException e) {
      System.out.println(String.format(SCIENCE_ERROR, e));
    }
    System.out.println(Thread.currentThread().getName() +
        String.format(END_WORK_SCIENCE, this.name, this.task));
  }
}
