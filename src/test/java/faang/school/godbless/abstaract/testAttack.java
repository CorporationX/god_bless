package faang.school.godbless.abstaract;

import faang.school.godbless.sprint_2.task_3.Archer;
import faang.school.godbless.sprint_2.task_3.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testAttack {
    @Test
    public void shouldCauseDamage(){
        Warrior warrior = new Warrior("Vasek");
        Archer archer = new Archer("Igorek");
        warrior.attack(archer);
        int factHealth = archer.getHealth();
        Assertions.assertEquals(90, factHealth);
    }
}
