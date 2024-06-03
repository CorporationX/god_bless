package faang.school.godbless.BJS2_7726;

public class Main {
  public static void main(String[] args) {
    Warrior warrior = new Warrior("War");
    Archer archer = new Archer("Arch");

    archer.attack(warrior);
    warrior.attack(archer);
    warrior.attack(archer);

    System.out.println(archer.getHealth());
    System.out.println(warrior.getHealth());
  }
}
