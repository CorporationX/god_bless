package faang.school.godbless.abstraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    void archerConstructorCorrectTest(){
        Character archer = new Archer("Ivan");
        assertAll(() -> {
            assertEquals(3, archer.strength);
            assertEquals(10, archer.agility);
            assertEquals(5, archer.intelligence);
        });
    }

    @Test
    @DisplayName("Атака на воина лучником")
    void archerAttackWarriorTest() {
        Character archer = new Archer("Ivan");
        Character warrior = new Archer("Peter");

        archer.attack(warrior);
        assertEquals(90, warrior.health);
    }

    @Test
    @DisplayName("Атака на лучника воином")
    void warriorAttackArcherTest() {
        Character archer = new Archer("Ivan");
        Character warrior = new Archer("Peter");

        warrior.attack(archer);
        assertEquals(90, archer.health);
    }

}