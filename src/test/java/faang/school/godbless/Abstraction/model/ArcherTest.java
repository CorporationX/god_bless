package faang.school.godbless.Abstraction.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {
    @Test
    public void attack_shouldReturnReducedWarriorHealth() {
        Warrior warrior = new Warrior("Alderheart");
        Archer archer = new Archer("Artemis");
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth());
        archer.attack(warrior);
        assertEquals(80, warrior.getHealth());
    }
}
