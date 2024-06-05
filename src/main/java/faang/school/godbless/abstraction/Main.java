package faang.school.godbless.abstraction;

import faang.school.godbless.abstraction.model.Archer;
import faang.school.godbless.abstraction.model.Character;
import faang.school.godbless.abstraction.model.Warrior;

/**
 * @author Evgenii Malkov
 */
public class Main {
  public static void main(String[] args) {
    Character archer = new Archer("Archer");
    Character warrior = new Warrior("Warrior");
    Character enemy = new Archer("Archer2");

    archer.attack(enemy);
    warrior.attack(enemy);
  }
}
