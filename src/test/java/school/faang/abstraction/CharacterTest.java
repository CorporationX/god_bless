package school.faang.abstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static school.faang.abstraction.DefaultCharacteristics.INIT_HP;
import static school.faang.abstraction.DefaultCharacteristics.MINIMUM_CHARACTER_HP;

class CharacterTest {

    private final Character warrior = new Warrior("Лотар");
    private final Character archer = new Archer("Леголас");

    @Test
    void testOneAttackWarrior() {
        int initArcherHitPoints = archer.getHitPoints();
        Assertions.assertEquals(INIT_HP, initArcherHitPoints);

        warrior.attack(archer);
        Assertions.assertEquals(archer.getHitPoints(), initArcherHitPoints - warrior.getStrength());
    }

    @Test
    void testOneAttackArcher() {
        int initWarriorHitPoints = warrior.getHitPoints();
        Assertions.assertEquals(INIT_HP, initWarriorHitPoints);

        archer.attack(warrior);
        Assertions.assertEquals(warrior.getHitPoints(), initWarriorHitPoints - archer.getAgility());
    }

    @Test
    void testWarriorCantAttackBelowZero() {
        ReflectionTestUtils.setField(archer, Character.Fields.hitPoints, 20);

        warrior.attack(archer);
        Assertions.assertEquals(10, archer.getHitPoints());
        warrior.attack(archer);
        Assertions.assertEquals(MINIMUM_CHARACTER_HP, archer.getHitPoints());
        warrior.attack(archer);
        Assertions.assertEquals(MINIMUM_CHARACTER_HP, archer.getHitPoints());
    }

    @Test
    void testArcherCantAttackBelowZero() {
        ReflectionTestUtils.setField(warrior, Character.Fields.hitPoints, 20);

        archer.attack(warrior);
        Assertions.assertEquals(10, warrior.getHitPoints());
        archer.attack(warrior);
        Assertions.assertEquals(MINIMUM_CHARACTER_HP, warrior.getHitPoints());
        archer.attack(warrior);
        Assertions.assertEquals(MINIMUM_CHARACTER_HP, warrior.getHitPoints());
    }

}