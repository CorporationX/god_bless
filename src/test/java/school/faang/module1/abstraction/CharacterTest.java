package school.faang.module1.abstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import school.faang.module1.abstraction.Archer;
import school.faang.module1.abstraction.Character;
import school.faang.module1.abstraction.Warrior;

import static school.faang.module1.abstraction.DefaultCharacteristics.INIT_HP;
import static school.faang.module1.abstraction.DefaultCharacteristics.MINIMUM_CHARACTER_HP;

class CharacterTest {

    private final school.faang.module1.abstraction.Character warrior = new Warrior("Лотар");
    private final school.faang.module1.abstraction.Character archer = new Archer("Леголас");

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
        ReflectionTestUtils.setField(archer, school.faang.module1.abstraction.Character.Fields.hitPoints, 20);

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