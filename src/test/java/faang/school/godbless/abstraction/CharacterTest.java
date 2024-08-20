package faang.school.godbless.abstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private static final int DEFAULT_HEALTH = 100;

    private static final int WARRIOR_POWER = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    private static final int ARCHER_POWER = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;

    @Test
    void testWarriorFields() {
        Warrior warrior = new Warrior("Сonan");

        Assertions.assertEquals(DEFAULT_HEALTH, warrior.health);
        Assertions.assertEquals(WARRIOR_POWER, warrior.power);
        Assertions.assertEquals(WARRIOR_AGILITY, warrior.agility);
        Assertions.assertEquals(WARRIOR_INTELLIGENCE, warrior.intelligence);
    }

    @Test
    void testArcherFields() {
        Archer archer = new Archer("Legolas");

        Assertions.assertEquals(DEFAULT_HEALTH, archer.health);
        Assertions.assertEquals(ARCHER_POWER, archer.power);
        Assertions.assertEquals(ARCHER_AGILITY, archer.agility);
        Assertions.assertEquals(ARCHER_INTELLIGENCE, archer.intelligence);
    }

    @Test
    void testWarriorAttack() {
        Warrior attackingCharacter = new Warrior("Conan");
        Archer attackedCharacter = new Archer("Legolas");

        attackingCharacter.attack(attackedCharacter);

        Assertions.assertEquals(DEFAULT_HEALTH - WARRIOR_POWER, attackedCharacter.health);
    }

    @Test
    void testArcherAttack() {
        Archer attackingCharacter = new Archer("Legolas");
        Warrior attackedCharacter = new Warrior("Conan");

        attackingCharacter.attack(attackedCharacter);

        Assertions.assertEquals(DEFAULT_HEALTH - ARCHER_AGILITY, attackedCharacter.health);
    }
}
