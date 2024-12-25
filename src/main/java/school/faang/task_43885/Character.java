package school.faang.task_43885;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public abstract class Character implements CharacterActions {

  private int health = 100;
  private String name;
  private int strength;
  private int dexterity;
  private int intelligence;

  public Character(String name) {
    this.name = name;
  }

  public Character (String name, int strength, int dexterity, int intelligence) {
    this.name = name;
    this.strength = strength;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Character character = (Character) o;
    return Objects.equals(name, character.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Character{" + "name='" + name + '\'' + '}';
  }

}