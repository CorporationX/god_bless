package faang.school.godbless.Abstraction.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    @Test
    public void testAttack() {
        Warrior warrior = new Warrior("Alderheart");
        Archer archer = new Archer("Artemis");
        archer.attack(warrior);
        assertEquals(90, warrior.health);
        warrior.attack(archer);
        assertEquals(90, archer.health);
        archer.attack(warrior);
        assertEquals(80, warrior.health);
    }
}
