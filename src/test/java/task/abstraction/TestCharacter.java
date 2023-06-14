package task.abstraction;

import faang.school.godbless.task.abstraction.Archer;
import faang.school.godbless.task.abstraction.Character;
import faang.school.godbless.task.abstraction.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestCharacter {
    @Test
    void testDamage() {
        Character warrior = new Warrior("Gimli");
        Character archer = new Archer("Legolas");
        warrior.attack(archer);
        assertEquals(90, archer.getHealth());
        warrior.attack(archer);
        assertEquals(80, archer.getHealth());
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth());
        archer.attack(warrior);
        assertEquals(80, warrior.getHealth());
    }
}
