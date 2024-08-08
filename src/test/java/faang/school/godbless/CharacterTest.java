package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void attackWarriorTest(){
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Conan");

        warrior.attack(archer);
        archer.attack(warrior);

        assertEquals(warrior.getHealth(), 90);
        assertEquals(archer.getHealth(), 90);
    }
}