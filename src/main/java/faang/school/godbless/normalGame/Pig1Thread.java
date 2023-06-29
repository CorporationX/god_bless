package faang.school.godbless.normalGame;

public class Pig1Thread extends PigThread {
  public Pig1Thread(String pigName) {
    super(pigName, Materials.STRAW);
  }

  @Override
  protected void build() throws InterruptedException {
    Thread.sleep(2000);
  }

  @Override
  public void run() {
    try {
      System.out.println(getPigName() + " build house from " + getMaterial());
      Thread.sleep(2000);
      System.out.println(getPigName() + " has finished building the house.");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
