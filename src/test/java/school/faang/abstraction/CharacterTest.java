package school.faang.abstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {

    private final Character warrior = new Warrior("Лотар");
    private final Character archer = new Archer("Леголас");

    @Test
    void testOneAttackWarrior() {
        int initArcherHitPoints = archer.hitPoints;
        Assertions.assertEquals(100, initArcherHitPoints);

        warrior.attack(archer);
        Assertions.assertEquals(archer.hitPoints, initArcherHitPoints - warrior.strength);
    }

    @Test
    void testOneAttackArcher() {
        int initWarriorHitPoints = warrior.hitPoints;
        Assertions.assertEquals(100, initWarriorHitPoints);

        archer.attack(warrior);
        Assertions.assertEquals(warrior.hitPoints, initWarriorHitPoints - archer.agility);
    }

    @Test
    void testWarriorCantAttackBelowZero() {
        for (int i = 0; i < 9; i++) {
            warrior.attack(archer);
        }

        Assertions.assertEquals(10, archer.hitPoints);
        warrior.attack(archer);
        Assertions.assertEquals(0, archer.hitPoints);
        warrior.attack(archer);
        Assertions.assertEquals(0, archer.hitPoints);
    }

    @Test
    void testArcherCantAttackBelowZero() {
        for (int i = 0; i < 9; i++) {
            archer.attack(warrior);
        }

        Assertions.assertEquals(10, warrior.hitPoints);
        archer.attack(warrior);
        Assertions.assertEquals(0, warrior.hitPoints);
        archer.attack(warrior);
        Assertions.assertEquals(0, warrior.hitPoints);
    }

}