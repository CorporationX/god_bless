package school.faang.task_43842;

class Warrior extends Character {
  public Warrior(String name) {
    super(name, 10, 5, 3);
  }

  @Override
  public void attack(Character target) {
    int damage = getStrength();
    target.setHealth(target.getHealth() - damage);
    System.out.println(getName() + " (Warrior) attacked " + target.getName() + " and inflicts " + damage + " damage");
  }
}

class Archer extends Character {
  public Archer(String name) {
    super(name, 3, 10, 5);
  }

  @Override
  public void attack(Character target) {
    int damage = getAgility();
    target.setHealth(target.getHealth() - damage);
    System.out.println(getName() + " (Archer) attacked " + target.getName() + " and inflicts " + damage + " damage");
  }
}


public class Main {
  public static void main(String[] args) {
    Warrior warrior = new Warrior("Thor");
    Archer archer = new Archer("Legolas");

    System.out.println(warrior.getName() + " has health: " + warrior.getHealth());
    System.out.println(archer.getName() + " has health: " + archer.getHealth());

    archer.attack(warrior);
    System.out.println(warrior.getName() + " attacked by " + archer.getName() + " and now has health: " + warrior.getHealth());

    warrior.attack(archer);
    System.out.println(archer.getName() + " attacked by " + warrior.getName() + " and now has health: " + archer.getHealth());
  }
}
