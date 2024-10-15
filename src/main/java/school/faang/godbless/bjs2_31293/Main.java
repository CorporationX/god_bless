package school.faang.godbless.bjs2_31293;

public class Main {

  public static void main(String[] args) {
    Character warrior = new Warrior("Geralt");
    Character archer = new Archer("Robin Good");
    warrior.attack(archer);
    archer.attack(warrior);
    System.out.println("Warrior health = " + warrior.getHealth());
    System.out.println("Archer health = " + archer.getHealth());
  }
}
