package faang.school.godbless.task3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {

    @Test
    @DisplayName("Здоровье лучника должно быть уменьшено на силу воина")
    void warriorAttackTest() {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Legolas");

        warrior.attack(archer);

        assertEquals(90, archer.getHealth());
    }

    @Test
    @DisplayName("Здоровье воина должно быть уменьшено в зависимости от ловкости лучника")
    void archerAttackTest() {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Legolas");

        archer.attack(warrior);

        assertEquals(90, warrior.getHealth());
    }



}