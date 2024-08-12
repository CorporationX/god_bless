package faang.school.godbless;

import faang.school.godbless.fight.Archer;
import faang.school.godbless.fight.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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