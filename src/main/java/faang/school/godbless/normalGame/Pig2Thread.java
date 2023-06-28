package faang.school.godbless.normalGame;

public class Pig2Thread extends PigThread {
  public Pig2Thread(String pigName) {
    super(pigName, Materials.STICK);
  }

  @Override
  public void run() {
    try {
      System.out.println(getPigName() + " build house from " + getMaterial());
      Thread.sleep(4000);
      System.out.println(getPigName() + " has finished building the house.");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
