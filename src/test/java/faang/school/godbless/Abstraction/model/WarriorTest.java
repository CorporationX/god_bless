package faang.school.godbless.Abstraction.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WarriorTest {
    @Test
    public void attack_shouldReturnReducedArcherHealth() {
        Warrior warrior = new Warrior("Alderheart");
        Archer archer = new Archer("Artemis");
        warrior.attack(archer);
        assertEquals(90, archer.getHealth());
    }
    @Test
    public void attack_shouldReturnException() {
        Warrior warrior = new Warrior("Alderheart");
        Archer archer = new Archer("Artemis");
        warrior.attack(archer);
        warrior.setHealth(10);
        assertThrows(IllegalArgumentException.class, () -> {
            archer.attack(warrior);
        });
    }
}
