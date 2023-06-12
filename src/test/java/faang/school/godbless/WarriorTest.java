package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior warrior;

    @BeforeEach
    public void setUp() {
        this.warrior = new Warrior("Warrior");
    }

    @Test
    void attackOtherWarriorTest() {
        Character enemy = new Warrior("Enemy");
        warrior.attack(enemy);

        assertEquals(90, enemy.getHealth());
    }

    @Test
    void attackArcherTest() {
        Character enemy = new Archer("Enemy");
        warrior.attack(enemy);

        assertEquals(90, enemy.getHealth());
    }

    @Test
    void attackDeathEnemyTest() {
        Character enemy = new Warrior("Enemy");

        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);

        assertEquals(0, enemy.getHealth());
    }
}