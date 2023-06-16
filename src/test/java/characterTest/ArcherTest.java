package characterTest;


import faang.school.godbless.Abstraction.character.Archer;
import faang.school.godbless.Abstraction.character.Character;
import faang.school.godbless.Abstraction.character.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {

    Character archer;
    Character warrior;

    @BeforeEach
    void start() {
       archer = new Archer("pavel");
       warrior = new Warrior("alex");
    }

    @Test
    void attackArcherTest() {
        int expected = 90;
        int result = archer.attack(warrior);
        assertEquals(expected, result);
    }

    @Test
    void attackWarriorTest() {
        int expected = 90;
        int result = warrior.attack(warrior);
        assertEquals(expected, result);
    }

}
