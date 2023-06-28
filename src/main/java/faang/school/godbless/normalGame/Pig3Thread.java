package faang.school.godbless.normalGame;

public class Pig3Thread extends PigThread {
  public Pig3Thread(String pigName) {
    super(pigName, Materials.BRICK);
  }

  @Override
  public void run() {
    try {
      System.out.println(getPigName() + " build house from " + getMaterial());
      Thread.sleep(1000);
      System.out.println(getPigName() + " has finished building the house.");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
