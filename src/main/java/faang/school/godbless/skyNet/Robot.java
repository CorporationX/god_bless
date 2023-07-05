package faang.school.godbless.skyNet;

public class Robot {
  private Target target;

  public Robot(Target target) {
    this.target = target;
  }

  public void attack() {
    synchronized (target) {
      System.out.println("Attacking: " + target.getName());
    }
  }
}
