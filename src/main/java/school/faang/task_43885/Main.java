package school.faang.task_43885;

public class Main {
  public static void main(String[] args) {

    Warrior warrior = new Warrior("Bob", 5, 5, 3);
    Archer archer = new Archer("Ben", 7, 5, 4);

    while (archer.getHealth() >= 0 && warrior.getHealth() >= 0) {
      archer.attack(warrior);
      warrior.attack(archer);

      if (archer.getHealth() <= 0) {
        System.out.println(archer.getName() + " is died");
      } else if (warrior.getHealth() <= 0) {
        System.out.println(warrior.getName() + " is dead");
      }
    }
  }
}
