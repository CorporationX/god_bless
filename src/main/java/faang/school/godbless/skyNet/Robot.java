package faang.school.godbless.skyNet;

public class Robot {
  private String target;

  public Robot(String target) {
    this.target = target;
  }

  public synchronized void attack() {
    System.out.println("Attacking: " + target);
  }
}
