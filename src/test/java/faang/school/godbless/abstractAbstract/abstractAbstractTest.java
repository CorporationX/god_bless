package faang.school.godbless.abstractAbstract;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class abstractAbstractTest {

    @Test
    void testAttack(){
        Archer archer = new Archer("Evan");
        Warrior warrior = new Warrior("BloodSeeker");

        archer.attack(warrior);

        warrior.attack(archer);
        warrior.attack(archer);

        Assertions.assertEquals(90, warrior.getHealth());
        Assertions.assertEquals(80, archer.getHealth());
    }
}