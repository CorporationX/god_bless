package faang.school.godbless.abstraction.model;

/**
 * @author Evgenii Malkov
 */
public abstract class Character {
  private String name;
  protected Integer power;
  protected Integer dexterity;
  protected Integer intellect;
  protected Integer health = 100;

  public Character(String name) {
    this.name = name;
  }

  public Character(String name, Integer power, Integer dexterity, Integer intellect) {
    this.name = name;
    this.power = power;
    this.dexterity = dexterity;
    this.intellect = intellect;
  }

  public abstract void attack(Character enemy);
}
