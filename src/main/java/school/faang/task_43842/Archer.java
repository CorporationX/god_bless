package school.faang.task_43842;

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
