package faang.school.godbless.bjs2_12541;

public record Player(String name, int power) {

  public void startBattle(Boss boss) {
      boss.joinBattle(this);
  }

}
