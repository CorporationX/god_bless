import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.abstraction.Archer;
import school.faang.abstraction.Warrior;

public class CharacterAttackTest {

  private final Warrior warrior = new Warrior("Warrior");
  private final Archer archer = new Archer("Archer");

  @BeforeEach
  void setUp() {

  }

  @Test
  @DisplayName("warrior attacks")
  void testWarriorAttack() {
    warrior.attack(archer);
    assertEquals(90, archer.getHealth());
  }

  @Test
  @DisplayName("archer attacks")
  void testArcherAttack() {
    archer.attack(warrior);
    assertEquals(90, warrior.getHealth());
  }
}
