package school.faang.task_43885;

public class Warrior extends Character {

  public Warrior(String name) {
    super(name);
  }

  public Warrior(String name, int strength, int dexterity, int intelligence) {
    super(name, strength, dexterity, intelligence);
  }

  @Override
  public int getHealth() {
    return super.getHealth();
  }

  @Override
  public void attack (Character target) {
    if (this.getHealth() > 0) {
      target.setHealth(target.getHealth() - this.getStrength());
    }
  }
}