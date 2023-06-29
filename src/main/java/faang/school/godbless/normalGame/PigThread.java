package faang.school.godbless.normalGame;

public abstract class PigThread extends Thread {
  private String pigName;
  private Materials material;

  public PigThread(String pigName, Materials material) {
    this.pigName = pigName;
    this.material = material;
  }

  public String getPigName() {
    return pigName;
  }

  public Materials getMaterial() {
    return material;
  }

  abstract protected void build() throws InterruptedException;

  @Override
  public void run() {
    try {
      System.out.println(getPigName() + " build house from " + getMaterial());
      build();
      System.out.println(getPigName() + " has finished building the house.");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
