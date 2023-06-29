package faang.school.godbless.normalGame;

public class Pig3Thread extends PigThread {
  public Pig3Thread(String pigName) {
    super(pigName, Materials.BRICK);
  }

  @Override
  protected void build() throws InterruptedException {
    Thread.sleep(6000);
  }
}
