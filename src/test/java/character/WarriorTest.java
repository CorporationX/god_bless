package character;

import faang.school.godbless.character.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {
  private Warrior warrior;
  private static final String WARRIOR_NAME = "Bloodseeker";
  @BeforeEach
  public void setUp() {
    warrior = new Warrior(WARRIOR_NAME);
  }

  @Test
  public void testArcherConstructor() {
    assertEquals(WARRIOR_NAME, warrior.getName());
    assertEquals(Warrior.DEFAULT_STRENGTH, warrior.getStrength());
    assertEquals(Warrior.DEFAULT_AGILITY, warrior.getAgility());
    assertEquals(Warrior.DEFAULT_INTELLIGENCE, warrior.getIntelligence());
  }

  @Test
  public void testAttack() {
    Warrior anotherPerson = new Warrior("Chaos Knight");
    int nextHealthValue = anotherPerson.getHealth() - warrior.getStrength();
    warrior.attack(anotherPerson);
    assertEquals(anotherPerson.getHealth(), nextHealthValue);
  }
}
