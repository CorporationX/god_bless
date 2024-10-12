package school.faang.character;

public class Main {
  public static void main(String[] args) {
    Character warrior = new Warrior("sven");
    Character archer = new Archer("windranger");

    System.out.println("warrior HP: " + warrior.getHealth());
    System.out.println("archer HP: " + archer.getHealth());

    archer.attack(warrior);
    archer.attack(warrior);

    warrior.attack(archer);

    System.out.println("warrior HP: " + warrior.getHealth());
    System.out.println("archer HP: " + archer.getHealth());
  }
}
