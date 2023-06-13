package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AttackTest {
    @Test
    void test() {
        Character war = new Warrior("War");
        Character arch = new Archer("Arch");

        war.attack(arch);
        arch.attack(war);

        Assertions.assertEquals(90, war.getHealth());
        Assertions.assertEquals(90, arch.getHealth());
        //System.out.println(war);
        //System.out.println(arch);
    }
}
