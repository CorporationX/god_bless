package faang.school.godbless.superCar;

public class Player {
  private String name;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void startBattle(Boss boss) {
    try {
      boss.joinBattle(this);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void finishBattle(Boss boss) {
    boss.leaveBattle(this);
  }
}
