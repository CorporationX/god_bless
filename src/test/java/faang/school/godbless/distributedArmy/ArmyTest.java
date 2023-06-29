package faang.school.godbless.distributedArmy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    @Test
    void returnAmountOfWarriors(){
        List<Warrior> warriorsList = new ArrayList<>();
        warriorsList.add(new Archer("Archer", 35));
        warriorsList.add(new Swordsman("Swordsman", 50));
        warriorsList.add(new Mage("Mage", 80));
        Army army = new Army(warriorsList);

        assertEquals(165, army.calculateTotalPower());
    }

}