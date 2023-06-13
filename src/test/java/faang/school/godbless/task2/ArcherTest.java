package faang.school.godbless.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void testAttack() {
        Warrior warrior = new Warrior("Leonid");
        Archer archer = new Archer("Arthur");

        warrior.attack(archer);
        warrior.attack(archer);

        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);

        int healthArtherAfterAttack = archer.getHealth();
        int healthWarriorAfterAttack = warrior.getHealth();

        assertEquals(80, healthArtherAfterAttack);
        assertEquals(70, healthWarriorAfterAttack);
    }
}