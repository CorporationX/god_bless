package faang.school.godbless.abstraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testCharacterAttack() {
        Character warrior = new Warrior("James");
        Character archer = new Archer("William");
        warrior.attack(archer);
        archer.attack(warrior);

        assertEquals(90, archer.getHp());
        assertEquals(90, warrior.getHp());
    }
}
