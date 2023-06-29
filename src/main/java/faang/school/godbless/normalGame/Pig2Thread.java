package faang.school.godbless.normalGame;

public class Pig2Thread extends PigThread {
  public Pig2Thread(String pigName) {
    super(pigName, Materials.STICK);
  }

  @Override
  protected void build() throws InterruptedException {
    Thread.sleep(5000);
  }
}
