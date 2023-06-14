package character;

import faang.school.godbless.character.Archer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {
  private Archer archer;
  private static final String ARCHER_NAME = "Drow Ranger";

  @BeforeEach
  public void setUp() {
    archer = new Archer(ARCHER_NAME);
  }

  @Test
  public void testArcherConstructor() {
    assertEquals(ARCHER_NAME, archer.getName());
    assertEquals(Archer.DEFAULT_STRENGTH, archer.getStrength());
    assertEquals(Archer.DEFAULT_AGILITY, archer.getAgility());
    assertEquals(Archer.DEFAULT_INTELLIGENCE, archer.getIntelligence());
  }

  @Test
  public void testAttack() {
    Archer anotherPerson = new Archer("Arc warden");
    int nextHealthValue = anotherPerson.getHealth() - archer.getAgility();
    archer.attack(anotherPerson);
    assertEquals(nextHealthValue, anotherPerson.getHealth());
  }
}
