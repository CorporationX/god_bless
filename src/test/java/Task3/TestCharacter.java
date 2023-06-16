package Task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCharacter {
    @Test
    public void testWarriorAttack() {
        Character warrior = new Warrior("War");
        Character archer = new Archer("Arc");
        warrior.attack(archer);
        Assertions.assertEquals(90, archer.getHealth());

    }

    @Test
    public void testArcherAttack() {
        Character warrior = new Warrior("War");
        Character archer = new Archer("Arc");
        archer.attack(warrior);
        Assertions.assertEquals(90, warrior.getHealth());

    }
}
