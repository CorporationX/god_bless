package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    private Archer archer;

    @BeforeEach
    public void setUp() {
        this.archer = new Archer("Archer");
    }

    @Test
    void attackOtherArcherTest() {
        Character enemy = new Archer("Enemy");
        archer.attack(enemy);

        assertEquals(90, enemy.getHealth());
    }

    @Test
    void attackWarriorTest() {
        Character enemy = new Warrior("Enemy");
        archer.attack(enemy);

        assertEquals(90, enemy.getHealth());
    }
}