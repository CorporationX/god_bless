package faang.school.godbless;

import faang.school.godbless.characters.Archer;
import faang.school.godbless.characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    @Test
    public void testWarriorAttack() {
        Warrior warrior = new Warrior("Warrior");
        Archer target = new Archer("Target");

        warrior.attack(target);

        assertEquals(90, target.getHealth());
    }

    @Test
    public void testArcherAttack() {
        Archer archer = new Archer("Archer");
        Warrior target = new Warrior("Target");

        archer.attack(target);

        assertEquals(90, target.getHealth());
    }
}
