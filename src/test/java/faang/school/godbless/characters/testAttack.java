package faang.school.godbless.characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAttack {
    @Test
    public void doDamage() {
        Warrior warrior = new Warrior("VOIN");
        Archer archer = new Archer("LUCHNIK");
        archer.attack(warrior);
        assertEquals(90, warrior.health);
    }
}
