package faang.school.godbless.normalGame;

public class PigThread extends Thread {
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
}
